# PostcodeSearch
##Usage
The application expects one or two arguments, which should represent a UK postcode.
It then:
- validates the given postcode
- if valid displays details about the postcode
- displays the nearest postcodes to the given postcode

##Implementation
The application uses Apache HTTP client to communicate with the postcode.io REST service API.
It processes the response using GSON and displays the output to the console.

##Assumptions
- The user will provide a postcode argument to the application and expect the result in the console
- The user is looking for UK postcodes
- It is expected that the given postcode is included in the list of nearest postcodes

##Further improvements

