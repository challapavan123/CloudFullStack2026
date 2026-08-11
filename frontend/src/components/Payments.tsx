import {useForm} from "react-hook-form";
import {paymentSchema,type PaymentFormData} from "../validators/validation.schema";
import {zodResolver} from "@hookform/resolvers/zod";

export const PaymentsPage: React.FC = () => {
    const {register,handleSubmit,formState:{errors}} =
    useForm<PaymentFormData>({
        resolver:zodResolver(paymentSchema),

    });
  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">

          <div className="card shadow">
            <div className="card-header bg-success text-white">
              <h4 className="mb-0">Payment Details</h4>
            </div>

            <div className="card-body">
              <form onSubmit={handleSubmit((data) => {
                console.log("Payment Data:", data);
              })}>

                {/* Card Holder */}
                <div className="mb-3">
                  <label className="form-label">Card Holder Name</label>
                  <input
                    className="form-control"
                    {...register("cardHolderName")}
                  />
                  <small className="text-danger">
                    {errors.cardHolderName?.message}
                  </small>
                </div>

                {/* Card Number */}
                <div className="mb-3">
                  <label className="form-label">Card Number</label>
                  <input
                    className="form-control"
                    maxLength={16}
                    {...register("cardNumber")}
                  />
                  <small className="text-danger">
                    {errors.cardNumber?.message}
                  </small>
                </div>

                {/* Expiry */}
                <div className="row mb-3">
                  <div className="col">
                    <label className="form-label">MM</label>
                    <input
                      className="form-control"
                      maxLength={2}
                      {...register("expiryDate")}
                    />
                    <small className="text-danger">
                      {errors.expiryDate?.message}
                    </small>
                  </div>

                  

                  <div className="col">
                    <label className="form-label">CVV</label>
                    <input
                      className="form-control"
                      maxLength={3}
                      {...register("cvv")}
                    />
                    <small className="text-danger">
                      {errors.cvv?.message}
                    </small>
                  </div>
                </div>

                

                {/* Submit */}
                <button
                  className="btn btn-success w-100"
                  type="submit"
                >
                  { "Processing..." }
                </button>

              </form>
            </div>
          </div>

        </div>
      </div>
    </div>
    
  );
};