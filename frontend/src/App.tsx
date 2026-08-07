
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import ProductsList from './components/productsList'
import AppLayout from './components/AppLayout'
import  { ProductDetails } from './components/productDetails'

function App() {
 

  return (
    <BrowserRouter>
    <Routes>
      <Route element={<AppLayout />} >
        <Route path="/products" element={<ProductsList />} />
        
  <Route path="/products/:id" element={<ProductDetails />} />
        <Route path="/about" element={<div>About Page</div>} />
        <Route path="/help" element={<div>Help Page</div>} />
        <Route path="/cart" element={<div>Cart Page</div>} />
      </Route>
      
      
    </Routes>
    </BrowserRouter>

     
    
  )
}

export default App
