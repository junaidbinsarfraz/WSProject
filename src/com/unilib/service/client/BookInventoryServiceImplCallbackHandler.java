
/**
 * BookInventoryServiceImplCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */

    package com.unilib.service.client;

    /**
     *  BookInventoryServiceImplCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class BookInventoryServiceImplCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public BookInventoryServiceImplCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public BookInventoryServiceImplCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for saveBook method
            * override this method for handling normal response from saveBook operation
            */
           public void receiveResultsaveBook(
                    com.unilib.service.client.BookInventoryServiceImplStub.SaveBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from saveBook operation
           */
            public void receiveErrorsaveBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validateBook method
            * override this method for handling normal response from validateBook operation
            */
           public void receiveResultvalidateBook(
                    com.unilib.service.client.BookInventoryServiceImplStub.ValidateBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validateBook operation
           */
            public void receiveErrorvalidateBook(java.lang.Exception e) {
            }
                


    }
    