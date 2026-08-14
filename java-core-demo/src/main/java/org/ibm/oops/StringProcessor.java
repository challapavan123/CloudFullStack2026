package org.ibm.oops;

@FunctionalInterface
public interface StringProcessor {

    String process(String input);
   default StringProcessor andThen(StringProcessor next){
    return input -> next.process(this.process(input));
   }
  
    

}
