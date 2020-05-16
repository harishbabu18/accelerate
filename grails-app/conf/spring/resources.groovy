import usermanagement.CustomAppRestAuthTokenJsonRenderer
import usermanagement.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    accessTokenJsonRenderer(CustomAppRestAuthTokenJsonRenderer)

}
