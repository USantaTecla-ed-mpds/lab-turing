export function assert(condition, message){
  if(false === condition){
    throw new Error(message ?? 'Assertion Failed')
  }
}