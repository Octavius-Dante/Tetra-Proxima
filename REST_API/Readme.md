
**What is RESTful API?**
</br>
</br>RESTful API is an interface that two computer systems use to exchange information securely over the internet. 
</br>Most business applications have to communicate with other internal and third-party applications to perform various tasks. 
</br>For example, to generate monthly payslips, your internal accounts system has to share data with your customer's 
</br>banking system to automate invoicing and communicate with an internal timesheet application. 
</br>RESTful APIs support this information exchange because they follow secure, reliable, and efficient software communication standards.
</br>
</br>

**What is an API?**
</br>
</br>An application programming interface (API) defines the rules that you must follow to communicate with other software systems. 
</br>Developers expose or create APIs so that other applications can communicate with their applications programmatically.
</br>For example, the timesheet application exposes an API that asks for an employee's full name and a range of dates.
</br>When it receives this information, it internally processes the employee's timesheet and returns the number of hours worked in that date range.
</br>
</br>You can think of a web API as a gateway between clients and resources on the web.
</br>
</br>

**Clients**
</br>
</br>Clients are users who want to access information from the web. 
</br>The client can be a person or a software system that uses the API. 
</br>For example, developers can write programs that access weather data from a weather system. 
</br>Or you can access the same data from your browser when you visit the weather website directly.
</br>
</br>

**Resources**
</br>
</br>Resources are the information that different applications provide to their clients. 
</br>Resources can be images, videos, text, numbers, or any type of data. 
</br>The machine that gives the resource to the client is also called the server. 
</br>Organizations use APIs to share resources and provide web services while maintaining security, control, and authentication. 
</br>In addition, APIs help them to determine which clients get access to specific internal resources.
</br>
</br>

**What is REST?**
</br>
</br>Representational State Transfer (REST) is a software architecture that imposes conditions on how an API should work. 
</br>REST was initially created as a guideline to manage communication on a complex network like the internet. 
</br>You can use REST-based architecture to support high-performing and reliable communication at scale.
</br>You can easily implement and modify it, bringing visibility and cross-platform portability to any API system.
</br>
</br>
</br>API developers can design APIs using several different architectures. 
</br>APIs that follow the REST architectural style are called REST APIs. 
</br>Web services that implement REST architecture are called RESTful web services. 
</br>The term RESTful API generally refers to RESTful web APIs. However, you can use the terms REST API and RESTful API interchangeably.
</br>
</br>
</br>The following are some of the principles of the REST architectural style:
</br>
</br>

**Uniform interface**
</br>
</br>The uniform interface is fundamental to the design of any RESTful webservice. 
</br>It indicates that the server transfers information in a standard format. 
</br>The formatted resource is called a representation in REST. 
</br>This format can be different from the internal representation of the resource on the server application. 
</br>For example, the server can store data as text but send it in an HTML representation format.
</br>
</br>

**Uniform interface imposes four architectural constraints:**
</br>
</br>Requests should identify resources. They do so by using a uniform resource identifier.
</br>Clients have enough information in the resource representation to modify or delete the resource if they want to. 
</br>The server meets this condition by sending metadata that describes the resource further.
</br>Clients receive information about how to process the representation further. 
</br>The server achieves this by sending self-descriptive messages that contain metadata about how the client can best use them.
</br>Clients receive information about all other related resources they need to complete a task. 
</br>The server achieves this by sending hyperlinks in the representation so that clients can dynamically discover more resources.
</br>
</br>

**Statelessness**
</br>
</br>In REST architecture, statelessness refers to a communication method in which the server completes 
</br>every client request independently of all previous requests. Clients can request resources in any order, 
</br>and every request is stateless or isolated from other requests. This REST API design constraint implies that the server 
</br>can completely understand and fulfill the request every time. 
</br>
</br>

**Layered system**
</br>
</br>In a layered system architecture, the client can connect to other authorized intermediaries 
</br>between the client and server, and it will still receive responses from the server. 
</br>Servers can also pass on requests to other servers. You can design your RESTful web service 
</br>to run on several servers with multiple layers such as security, application, and business logic, 
</br>working together to fulfill client requests. These layers remain invisible to the client.
</br>
</br>

**Cacheability**
</br>
</br>RESTful web services support caching, which is the process of storing some responses 
</br>on the client or on an intermediary to improve server response time. For example, suppose 
</br>that you visit a website that has common header and footer images on every page. 
</br>Every time you visit a new website page, the server must resend the same images. 
</br>To avoid this, the client caches or stores these images after the first response and 
</br>then uses the images directly from the cache. RESTful web services control caching by 
</br>using API responses that define themselves as cacheable or noncacheable.
</br>
</br>

**Code on demand**
</br>
</br>In REST architectural style, servers can temporarily extend or customize client functionality 
</br>by transferring software programming code to the client. For example, when you fill a 
</br>registration form on any website, your browser immediately highlights any mistakes you make, 
</br>such as incorrect phone numbers. It can do this because of the code sent by the server.
</br>
</br>

**What are the benefits of RESTful APIs?**
</br>

**RESTful APIs include the following benefits:**
</br>

**Scalability**
</br>
</br>Systems that implement REST APIs can scale efficiently because REST optimizes 
</br>client-server interactions. Statelessness removes server load because the server does not have 
</br>to retain past client request information. Well-managed caching partially or completely 
</br>eliminates some client-server interactions. All these features support scalability without 
</br>causing communication bottlenecks that reduce performance.
</br>
</br>

**Flexibility**
</br>
</br>RESTful web services support total client-server separation. 
</br>They simplify and decouple various server components so that each part can evolve independently. 
</br>Platform or technology changes at the server application do not affect the client application. 
</br>The ability to layer application functions increases flexibility even further. 
</br>For example, developers can make changes to the database layer without rewriting the application logic.
</br>
</br>

**Independence**
</br>
</br>REST APIs are independent of the technology used. 
</br>You can write both client and server applications in various programming languages 
</br>without affecting the API design. You can also change the underlying technology 
</br>on either side without affecting the communication.
</br>
</br>

**How do RESTful APIs work?**
</br>
</br>The basic function of a RESTful API is the same as browsing the internet. 
</br>The client contacts the server by using the API when it requires a resource. 
</br>API developers explain how the client should use the REST API in the server application 
</br>API documentation. These are the general steps for any REST API call:
</br>
</br>

**The client sends a request to the server.**
</br>
</br>The client follows the API documentation to format the request in a way that the server understands.
</br>The server authenticates the client and confirms that the client has the right to make that request.
</br>The server receives the request and processes it internally.
</br>The server returns a response to the client. The response contains information that tells 
</br>the client whether the request was successful. The response also includes any information that the client requested.
</br>The REST API request and response details vary slightly depending on how the API developers design the API.
</br>
</br>

**What does the RESTful API client request contain?**
</br>

**RESTful APIs require requests to contain the following main components:**
</br>
</br>

**Unique resource identifier**
</br>
</br>The server identifies each resource with unique resource identifiers. 
</br>For REST services, the server typically performs resource identification by using 
</br>a Uniform Resource Locator (URL). The URL specifies the path to the resource. 
</br>A URL is similar to the website address that you enter into your browser to visit any webpage. 
</br>The URL is also called the request endpoint and clearly specifies to the server what the client requires.
</br>
</br>

**Method**
</br>
</br>Developers often implement RESTful APIs by using the Hypertext Transfer Protocol (HTTP). 
</br>An HTTP method tells the server what it needs to do to the resource. 
</br>
</br>The following are four common HTTP methods:
</br>

**GET**
</br>
</br>Clients use GET to access resources that are located at the specified URL on the server. 
</br>They can cache GET requests and send parameters in the RESTful API request to instruct the server to filter data before sending.
</br>
</br>

**POST**
</br>
</br>Clients use POST to send data to the server. 
</br>They include the data representation with the request. 
</br>Sending the same POST request multiple times has the side effect of creating the same resource multiple times.
</br>
</br>

**PUT**
</br>
</br>Clients use PUT to update existing resources on the server. 
</br>Unlike POST, sending the same PUT request multiple times in a RESTful web service gives the same result.
</br>
</br>

**DELETE**
</br>
</br>Clients use the DELETE request to remove the resource. 
</br>A DELETE request can change the server state. However, 
</br>if the user does not have appropriate authentication, the request fails.
</br>
</br>

**HTTP headers**
</br>
</br>Request headers are the metadata exchanged between the client and server. 
</br>For instance, the request header indicates the format of the request and response, 
</br>provides information about request status, and so on.
</br>
</br>

**Data**
</br>
</br>REST API requests might include data for the POST, PUT, and other HTTP methods to work successfully.
</br>
</br>

**Parameters**
</br>
</br>RESTful API requests can include parameters that give the server more details about what needs to be done. 
</br>The following are some different types of parameters:
</br>
</br>
</br>Path parameters that specify URL details.
</br>Query parameters that request more information about the resource.
</br>Cookie parameters that authenticate clients quickly.
</br>
</br>

**What are RESTful API authentication methods?**
</br>
</br>A RESTful web service must authenticate requests before it can send a response. 
</br>Authentication is the process of verifying an identity. For example, you can prove your 
</br>identity by showing an ID card or driver's license. Similarly, 
</br>RESTful service clients must prove their identity to the server to establish trust.
</br>
</br>

**RESTful API has four common authentication methods:**
</br>
</br>

**HTTP authentication**
</br>
</br>HTTP defines some authentication schemes that you can use directly when you are implementing REST API. The following are two of these schemes:
</br>
</br>

**Basic authentication**
</br>
</br>In basic authentication, the client sends the user name and password in the request header. 
</br>It encodes them with base64, which is an encoding technique that converts the pair into a set of 64 characters for safe transmission.
</br>
</br>

**Bearer authentication**
</br>
</br>The term bearer authentication refers to the process of giving access control to the token bearer. 
</br>The bearer token is typically an encrypted string of characters that the server generates in response to a login request. 
</br>The client sends the token in the request headers to access resources.
</br>
</br>

**API keys**
</br>
</br>API keys are another option for REST API authentication. 
</br>In this approach, the server assigns a unique generated value to a first-time client. 
</br>Whenever the client tries to access resources, it uses the unique API key to verify itself. 
</br>API keys are less secure because the client has to transmit the key, which makes it vulnerable to network theft.
</br>
</br>

**OAuth**
</br>
</br>OAuth combines passwords and tokens for highly secure login access to any system. 
</br>The server first requests a password and then asks for an additional token to complete the authorization process. 
</br>It can check the token at any time and also over time with a specific scope and longevity.
</br>
</br>

**What does the RESTful API server response contain?**
</br>
</br>REST principles require the server response to contain the following main components:
</br>
</br>

**Status line**
</br>
</br>The status line contains a three-digit status code that communicates request success or failure. 
</br>For instance, 2XX codes indicate success, but 4XX and 5XX codes indicate errors. 3XX codes indicate URL redirection.
</br>
</br>
</br>The following are some common status codes:
</br>
</br>
</br>200: Generic success response
</br>201: POST method success response
</br>400: Incorrect request that the server cannot process
</br>404: Resource not found
</br>
</br>

**Message body**
</br>
</br>The response body contains the resource representation. 
</br>The server selects an appropriate representation format based on what the request headers contain. 
</br>Clients can request information in XML or JSON formats, which define how the data is written in plain text. For example, 
</br>if the client requests the name and age of a person named John, 
</br>
</br>

</br>the server returns a JSON representation as follows:
</br>'{"name":"John", "age":30}'
</br>
</br>

**Headers**
</br>
</br>The response also contains headers or metadata about the response. 
</br>They give more context about the response and include information such as the server, encoding, date, and content type.