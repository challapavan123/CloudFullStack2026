import {z} from "zod";

export const paymentSchema = z.object({
    cardNumber: z.string()
    .min(16, "Card number must be 16 digits")
    .max(16, "Card number must be 16 digits"),
    cardHolderName: z.string()
    .min(1, "Card holder name is required"),
    expirationDate: z.string()
    .regex(/^(0[1-9]|1[0-2])\/\d{2}$/, "Expiration date must be in MM/YY format"),
    cvv: z.string()
    .min(3, "CVV must be 3 digits").max(3, "CVV must be 3 digits"),
})
export type PaymentFormData = z.infer<typeof paymentSchema>;