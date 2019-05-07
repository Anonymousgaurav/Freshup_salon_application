package com.example.swag.Interface;

import com.example.swag.Model.AddToCartModel;
import com.example.swag.Model.AppointmentModel;
import com.example.swag.Model.BarbarDetailsModel;
import com.example.swag.Model.BookingServicesModel;
import com.example.swag.Model.GetAddToCartListModel;
import com.example.swag.Model.GetHomeDataModel;
import com.example.swag.Model.GetProfilePojo;
import com.example.swag.Model.GetServicesDataModel;
import com.example.swag.Model.GetSubSubServices;
import com.example.swag.Model.OrderHistoryModel;
import com.example.swag.Model.OtpPojo;
import com.example.swag.Model.PaymentModel;
import com.example.swag.Model.PaypaldataModel;
import com.example.swag.Model.ProductBuyModel;
import com.example.swag.Model.QueueModelClass;
import com.example.swag.Model.RegisterModel;
import com.example.swag.Model.SimplePojo;
import com.example.swag.Model.SingleProductCategoryModel;
import com.example.swag.Model.SocialLoginModel;
import com.example.swag.Model.SocialLoginModelClass;
import com.example.swag.Model.TokenModel;
import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api
{

    @FormUrlEncoded
    @POST("userRegister")
    Call<RegisterModel> UserRegister(@Field("name") String name,
                                     @Field("email") String email,
                                     @Field("phone") String phone,
                                     @Field("password") String password,
                                     @Field("device_type") String device_type,
                                     @Field("reg_id") String reg_id);

    @FormUrlEncoded
    @POST("matchVerificationToken")
    Call<SimplePojo> matchToken(@Field("id") int id,
                                @Field("token") String token);

    @FormUrlEncoded
    @POST("userLogin")
    Call<GetProfilePojo> UserLogin(@Field("email") String email,
                                   @Field("password") String password);

    @FormUrlEncoded
    @POST("resendVerificationToken")
    Call<OtpPojo> resendToken(@Field("id") String id);


    @FormUrlEncoded
    @POST("userGetProfile")
    Call<GetProfilePojo> getProfile(@Field("userId") String id);

    @Multipart
    @POST("userUpdateProfile")
    Call<GetProfilePojo> updateProfile(@Part("userId") RequestBody userId,
                                       @Part("name") RequestBody name,
                                       @Part("phone") RequestBody phone,
                                       @Part MultipartBody.Part image);

    @FormUrlEncoded
    @POST("forgotPassword")
    Call<Map> forgetPassword(@Field("email") String email);

    //change password
    @FormUrlEncoded
    @POST("changePassword")
    Call<Map> changePassword(@Field("userId") String userid,
                             @Field("old_password") String old_password,
                             @Field("new_password") String new_password);

    @GET("getServices")
    Call<GetHomeDataModel> getServices();

    @GET("getProduct")
    Call<GetHomeDataModel> getProduct();

    @FormUrlEncoded
    @POST("getSubServices")
    Call<GetServicesDataModel> getSubServices(@Field("serviceId") String serviceId);

    @FormUrlEncoded
    @POST("getSubSubServices")
    Call<GetSubSubServices> getSubSubServices(@Field("subServiceId") String subServiceId);


    @FormUrlEncoded
    @POST("getSubCategoryAndProduct")
    Call<SingleProductCategoryModel> getProducts(@Field("categoryId") String categoryId,
                                                 @Field("userId") String userId);

    @FormUrlEncoded
    @POST("getBarberDetails")
    Call<BarbarDetailsModel> barbarDetail(@Field("apointmentDate") String apointmentDate);

    @FormUrlEncoded
    @POST("userBookingServices")
    Call<BookingServicesModel> booking(@Field("user_id") String user_id,
                                       @Field("subSubService_id") String subSubService_id,
                                       @Field("barber_id") String barber_id,
                                       @Field("apointmentDate") String apointmentDate,
                                       @Field("timeslot") String timeslot);

    @FormUrlEncoded
    @POST("getUserBookingSercices")
    Call<AppointmentModel> getAppointment(@Field("userId") String userId,
                                          @Field("currentTime") String currentTime);

    @FormUrlEncoded
    @POST("addToCart")
    Call<AddToCartModel> addtocart(@Field("userId") String userId,
                                   @Field("productId") String productId,
                                   @Field("quantity") Integer quantity);

    @FormUrlEncoded
    @POST("getDataFromCart")
    Call<GetAddToCartListModel> getCartList(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("deleteDataFromCart")
    Call<Map> DeleteItems(@Field("id") String id);

    @FormUrlEncoded
    @POST("UserSocialLogin")
    Call<SocialLoginModel> SocialLogin(@Field("name") String name,
                                       @Field("email") String email,
                                       @Field("image") String image,
                                       @Field("phone") String phone,
                                       @Field("social_id") String social_id,
                                       @Field("device_type") String device_type,
                                       @Field("reg_id") String reg_id,
                                       @Field("login_type") String login_type);

    @FormUrlEncoded
    @POST("userPaymentAcceptance")
    Call<ProductBuyModel> buyProduct(@Field("paymentMethod") String paymentMethod,
                                     @Field("userId") String userId,
                                     @Field("country") String country,
                                     @Field("state") String state,
                                     @Field("city") String city,
                                     @Field("address") String address,
                                     @Field("zipCode") String zipCode,
                                     @Field("amount") String amount,
                                     @Field("token") String token,
                                     @Field("addToCartId") String addToCartId,
                                     @Field("orderId") String orderId);

    @FormUrlEncoded
    @POST("userServicesPaymentAcceptance")
    Call<Map> bookingServicePayment(@Field("paymentMethod") String paymentMethod,
                                    @Field("userId") String userId,
                                    @Field("bokingServiceId") String bokingServiceId,
                                    @Field("token") String token,
                                    @Field("amount") String amount,
                                    @Field("subSubService_id") String subSubService_id,
                                    @Field("barber_id") String barber_id,
                                    @Field("apointmentDate") String apointmentDate,
                                    @Field("timeslot") String timeslot);

    @FormUrlEncoded
    @POST("userProductSaleOrderHistory")
    Call<OrderHistoryModel> orderHistory(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("checkSocialId")
    Call<SocialLoginModelClass> CheckSocialId(@Field("social_id") String social_id);

    @FormUrlEncoded
    @POST("userCancelBookingService")
    Call<Map> Cancel(@Field("bookingServiceId") String bookingServiceId);


    @FormUrlEncoded
    @POST("getBarberBokkingServiceDetails")
    Call<QueueModelClass> JoinQueue(@Field("apointmentDate") String apointmentDate);

    @FormUrlEncoded
    @POST("joinQueBookingService")
    Call<Map> justJoin(@Field("userId") String userId,
                       @Field("apointmentDate") String apointmentDate,
                       @Field("barberId") String barberId);


    @GET("genrateToken")
    Call<TokenModel> getToken();




    @FormUrlEncoded
    @POST("paypalCheckOut")
    Call<PaypaldataModel> getCheckOut(@Field("amount") String ammount,
                                      @Field("nonce") String nonce);

    @GET("paymentStatus")
    Call<PaymentModel> getPaymentModel();
}
