const Title =() => {
    useEffect(() => {       
        window.title = "Products List";
    
    return ()=>{
        window.title = "MERN Stack";
    }
},[])
};
