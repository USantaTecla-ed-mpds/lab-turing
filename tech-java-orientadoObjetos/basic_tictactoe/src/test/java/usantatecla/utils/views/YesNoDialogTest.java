package usantatecla.utils.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class YesNoDialogTest {

  private YesNoDialog yesNoDialog;
  private String title = "TITLE";

  @Mock
  private Console console;

  @BeforeEach
  void beforeEach() {
    this.yesNoDialog = new YesNoDialog();
  }

  @Test
  public void testGivenYesNoDialogWhenReadThenIsAffirmative() {
    try (MockedStatic<Console> console = mockStatic(Console.class)) {
      console.when(Console::getInstance).thenReturn(this.console);

      final String[] YES = new String[]{"y", "Y"};
      for (int i = 0; i < YES.length; i++) {
        when(this.console.readString("? (y/n): ")).thenReturn(YES[i]);
        this.yesNoDialog.read(this.title);
        assertThat(this.yesNoDialog.isAffirmative(), is(true));
      }
    }
  }

  @Test
  public void testGivenYesNoDialogWhenReadThenIsNegative() {
    try (MockedStatic<Console> console = mockStatic(Console.class)) {
      console.when(Console::getInstance).thenReturn(this.console);

      final String[] NO = new String[]{"n", "N"};
      for (int i = 0; i < NO.length; i++) {
        when(this.console.readString("? (y/n): ")).thenReturn(NO[i]);
        this.yesNoDialog.read(this.title);
        assertThat(this.yesNoDialog.isAffirmative(), is(false));
      }
    }
  }
  
  @Test
  public void testGivenYesNoDialogWhenReadThenRepeatWithError() {
    try (MockedStatic<Console> console = mockStatic(Console.class)) {
      console.when(Console::getInstance).thenReturn(this.console);

      when(this.console.readString("? (y/n): ")).thenReturn(" ", "1", "s", "*", "y");
      this.yesNoDialog.read(this.title);
      verify(this.console, times(4)).writeln("The value must be 'y' or 'n'");
      assertThat(this.yesNoDialog.isAffirmative(), is(true));
    }
  }
  
}
