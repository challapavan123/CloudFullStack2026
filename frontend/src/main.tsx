
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';
import { CartProvider } from './components/cartstore.tsx';

createRoot(document.getElementById('root')!).render(
<CartProvider>
    <App />
    </CartProvider>
 
)
