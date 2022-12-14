var a = "a";
console.log(a);
console.log(this.a);
console.log(window.a);
console.log(this["a"]);
console.log(window["a"]);

b = "b";
console.log(b);
console.log(this.b);
console.log(window.b);
console.log(this["b"]);
console.log(window["b"]);

this.c = "c";
console.log(c);
console.log(this.c);
console.log(window.c);
console.log(this["c"]);
console.log(window["c"]);

window.d = "d";
console.log(d);
console.log(this.d);
console.log(window.d);
console.log(this["d"]);
console.log(window["d"]);

let e = "e";
console.log(e);
console.log(this.e);
console.log(window.e);
console.log(this["e"]);
console.log(window["e"]);

function f(){
  return "f";
}
console.log(f);
console.log(this.f);
console.log(window.f);
console.log(this["f"]);
console.log(window["f"]);
console.log(f());
console.log(this.f());
console.log(window.f());
console.log(this["f"]());
console.log(window["f"]());

var g = function(){
  return "f";
}
console.log(g);
console.log(this.g);
console.log(window.g);
console.log(g());
console.log(this.g());
console.log(window.g());

h = function(){
  return "h";
}
console.log(h);
console.log(this.h);
console.log(window.h);
console.log(h());
console.log(this.h());
console.log(window.h());

this.i = function(){
  return "i";
}
console.log(i);
console.log(this.i);
console.log(window.i);
console.log(i());
console.log(this.i());
console.log(window.i());

window.j = function(){
  return "j";
}
console.log(j);
console.log(this.j);
console.log(window.j);
console.log(j());
console.log(this.j());
console.log(window.j());
