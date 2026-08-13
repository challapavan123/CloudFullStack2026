import { useNavigate } from "react-router-dom";
import {useAppSelector} from '../store/hooks';


const Cart = () => {
const items = useAppSelector((state) => state.cart.items);
  
  
  const navigate = useNavigate();

  const checkout = () => {
    navigate("/checkout");
  };

  return (
    <div className="cart-sidebar">

      {/* Header */}
      <div className="cart-header d-flex justify-content-between align-items-center">
        <h5>My Cart</h5>
        <button className="btn-close"></button>
      </div>

      {/* Empty Cart */}
      {items.length === 0 ? (
        <p className="text-center mt-4">Cart is empty</p>
      ) : (
        <>
          {/* Cart Items */}
          <div className="cart-body">
            {items.map(item => (
              <div
                className="cart-item d-flex justify-content-between"
                key={item.product.id}
              >
                <strong>{item.product.name}</strong>

                <small className="text-muted">
                  ₹ {item.product.price * item.quantity}
                </small>
              </div>
            ))}
          </div>

          {/* Footer */}
          <div className="cart-footer">
            <button
              className="btn btn-success w-100 mt-2"
              onClick={checkout}
            >
              Checkout
            </button>
          </div>
        </>
      )}
    </div>
  );
};

export default Cart;
