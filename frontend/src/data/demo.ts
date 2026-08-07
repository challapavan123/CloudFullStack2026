let c =3;
const add =(a: number,b: number,c: number)=>{
    console.log(a,b);
    return new Promise((resolve)=>{
    setTimeout(()=>{
        resolve(a+b+c);
    },1000)
    })} 
c= 4;
((async()=>{
    const result = await add(1,2,c);
    console.log(result);
})());  
