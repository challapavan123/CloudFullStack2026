import {createSlice} from '@reduxjs/toolkit';
import type {PayloadAction} from '@reduxjs/toolkit';
import type {ICartItem} from '../model/cartitem';
import type IProduct from '../model/product';
interface CartState {
    items: ICartItem[];
}
const initialState: CartState = {
    items: JSON.parse(localStorage.getItem('cartItems') || '[]') as CartItem[]
};
const cartSlice = createSlice({ 
        name: 'cart',
        initialState,
        reducers: {
            addToCart: (state, action: PayloadAction<IProduct>) => {
                const product = action.payload;
                const existingItem = state.items.find(item => 
                    item.product.id === product.id);
                if (existingItem) {
                    existingItem.quantity += 1;
                } else {
                    state.items.push({ product, quantity: 1 });
                }
                localStorage.setItem('cartItems', JSON.stringify(state.items));
            }
        }
    });
export const { addToCart } = cartSlice.actions;
export default cartSlice.reducer;