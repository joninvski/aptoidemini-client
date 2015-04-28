Remote module
=============

Library to the REST calls to the server

## Gradle targets

Build the jar file
    ./gradlew

Execute the unit tests
    ./gradlew :remote:test

Execute the integration tests
    ./gradlew :remote:integTest

## Usage summary:

   1.  Create an instance of AptoideRestClient.java

        // first parameter is the communication bus
        AptoideRestClient rest = new AptoideRestClient(getBus());

   2. Call the assynchronous function on the AptoideRestClient object
        rest.registerUser(email, pass, ...)

   3. An assynchronous event will apear in the communication bus (it's that simple)

        // Normally events are consume using the @Subscribe tag
        // All events extend from BaseEvent
        // NOTHING WILL BE ON THE BUS WHICH DOES NOT EXTEND FROM THIS CLASS
        @Subscribe
        void myMethod(ChildOfBaseEventd) { ... }

If any doubt, just use the sample app (TODO)

## For developers

    1. First create com.aptoidemini.rest.object representing the parameters to be passed / received

        public class UserRest {
                @SerializedName("email") public String email;
                ...
        }

    2. Write the REST method in the interface in AptoideRestCLient

        public interface RestInterface {
            ....
            @POST("/api/new/")
            public void userRegister(
                    @Body UserRest user,
                    Callback<UserRest> callback );
            ....
        }

    3. Just create a simple function to publicly export the function

        // The function shown to library users
        public void registerUser(DomainObject o ) {

            //3.1 Create the callback
            NewUserCallback callback = new NewUserCallback(mBus);

            //3.2 Transform from the domain object to the rest object
            ProfileRest restProfile = ProfileRest.fromDomain(profile);
            UserRest restUser = new UserRest(email, password, restProfile);

            // Now lets actually do the remote rest call
            restInterface.userRegister( restUser, callback );
        }

    4. Create a callback in the com.aptoidemini.remote.callback packages.
        There are 4 simple rules

        4.1 Extend from AbstractCallback
            public class NewUserCallback extends AbstractCallback<UserRest> {

        4.2 Have a constructure that receives the bus
            public NewUserCallback(Bus bus) {
                this.mBus = bus;
            }

        4.3 Implement the success method

            @Override
            public void success( UserRest user, Response response ) {
                UserRegistredEvent event = UserRegistredEvent.getEvent(user);
                mBus.post( event );
            }

        4.4 Implement the onError method

            String errorJson = getBodyFromError(e);
            if(errorJson.contains("...")){
                Event event = ...
                mBus.post( event );
            }

    5. Create the Mock Rest interface in com.aptoidemini.test.mock

        public class NewUserMock extends AbstractRestMocker {
            private static final String OK_RETURN = "" +
                "{\"email\": [\"Some json.\"]};";

        // For tests to create the mocks
        public static NewUserMock getOkMock(String params) {
            String response = String.format(Locale.US, params);
            return new NewUserMock(response, HTTP_OK_STATUS);
        }

    6. Create the unit test in com.aptoidemini.remote.test.service
        Just two rules.

        6.1. It should extend the AbstractServiceTest
        6.1. When overriding the setup, the super.setup() should be the last thing called

    7. Create the integration test at com.aptoidemini.remote.integration.test.service;

        7.1 Just extend from the unit test and don't forget to override the getRestClient

            @Override
            public AptoideRestClient getRestClient(AbstractRestMocker ignoringIt) {
                AptoideRestClient rest = new AptoideRestClient(getMockBus());
                return rest;
            }
