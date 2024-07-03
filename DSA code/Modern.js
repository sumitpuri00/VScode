// Arrow function;

const multiplication=(a,b)=>{
          return a*b;
}


console.log(multiplication(2,5));

let count=0;
const totalVowel=(antString)=>{
          const vowel="aeiou";
          for(i of vowel){
                    for(j of antString){
                              if(i===j){
                                        count++
                              }
                    }
          }
          return count;

}

console.log(totalVowel("aaaaii"));

let number =[1,2,3,4,5];

number.forEach((value)=>{
          console.log(value*2);
})




console.log("this is a new class");


class laptop{
          constructor(name,sumit){
                    this.name=name;
                    this.sumit=sumit;
          }

           
}

const laptopVariable=new laptop("sumit","name");
console.log(laptopVariable.sumit);


class person{
          constructor(species){
                    console.log("this is parent");
                    this.species=species;
          }
          eat(){
                    console.log("person will eat");
          }
}

class worker extends person{
          constructor(work){
                    
                    super(); 
                    console.log("this is child");
                    this.work=work;

          }
          work(){
                    console.log("i will work");
          }

           
}


const workerobj=new worker("robo");
workerobj.eat();
console.log(workerobj.species);


console.log("this is asynchronous");
setTimeout(()=>{
          console.log("set timeout");
}, 4000);


function sum(a,b){
          console.log(a+b);
}
function calculator(a,b,call){
          call(a,b);


}

calculator(27,8,sum);



