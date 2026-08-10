
import type { ICartItem } from '../model/cartitem';
import type  IProduct  from '../model/product';
import { createContext,useContext,useEffect, useReducer } from 'react';



 const CART_KEY = 'CART_KEY';

 interface CartState{
  items: ICartItem[];
 }

 type CartAction = {
  type: 'ADD_TO_CART';
  payload: IProduct;
 }
 const initialState: CartState = {
  items: JSON.parse(localStorage.getItem(CART_KEY) || '[]') as ICartItem[],
 }
 /*eslint no-case-declarations: "error"*/
 const cartReducer = (state: CartState, action: CartAction): CartState => {
  switch (action.type) {
    case 'ADD_TO_CART':{
      const product = action.payload;
      const existingItem = state.items.find(item => item.product.id === product.id);
      if (existingItem) {
        return {
          ...state,
          items: state.items.map(item =>
            item.product.id === product.id
              ? { ...item, quantity: item.quantity + 1 }
              : item
          )
        };
      } else {
        return {
          ...state,
          items: [...state.items, { product, quantity: 1 }]
        };
      }
    }
    default:
      return state;
  }
 }
 export const CartContext = createContext<{
  items: ICartItem[];
  addToCart: (product: IProduct) => void;
} | null>(null);


  export const CartProvider = ({children}: {children: React.ReactNode}) => {
    const [state, dispatch] = useReducer(cartReducer, initialState);
  
    useEffect(() => {
      localStorage.setItem(CART_KEY, JSON.stringify(state.items));
    }, [state.items]);
  
    const addToCart = (product: IProduct) => {
      dispatch({ type: 'ADD_TO_CART', payload: product });
    };
  
    return (
      <CartContext.Provider value={{ items: state.items, addToCart }}>
        {children}
      </CartContext.Provider>
    );
  };
  
  export const useCart = () => {    
    const context = useContext(CartContext);
    if (!context) {
      throw new Error('useCart must be used within a CartProvider');
    }
    return context;
  }

// reduxtoolkit
// redux
// redux-thunk
// reselect
// immer
// configureStore
// createStore
// createSlice
// createAsyncThunk
// createSelector




