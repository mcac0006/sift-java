sift-java
=========

Java library which help integrate your Java application to Sift Science (http://www.siftscience.com) quicker and easier.

This library has been made using Jersey (https://jersey.java.net) for the transport layer and Jackson JSON Processor (http://jackson.codehaus.org) as (de)serializer.

1. Installation (using Maven)
-----------------------------

The library is not distributed anywhere yet, so you will need to `mvn install` it and add the following dependency to your project:

```
<dependency>  
	<groupId>com.mcac0006.siftscience</groupId>  
	<artifactId>sift-java</artifactId>  
	<version>1.0.0-SNAPSHOT</version>  
</dependency>
```

2. How to use
-------------

```
final SiftScience helper = new SiftScience('API_KEY_GOES_HERE'); // instantiate the helper
```

```
// Sending a an Event is easy! Let's create a Transaction ($transaction) event.
final Event event = new Transaction(); // create an event
event.setX(...).setY(...).setZ(...); //fill in all fields using setters

// ... you can also add custom fields of your own to any event!
event.addCustomField('key1', 'value1');
event.addCustomField('key2', 'value2');
...

final SiftScienceResult ssr = helper.send(event); //send the event to SiftScience

```

```
// Labels are also created in the same fashion
final Label label = new Label(); // create an event
label.setX(...).setY(...).setZ(...); //fill in all fields using setters

final SiftScienceResult ssr = helper.send(event); //send the event to SiftScience
```

```
// If you're interested in getting the SiftScore for that particular user ...
final SiftScienceScore score = helper.getScore('mcac0006');
// Use the getters to retrieve the score information, such as ...
score.getScore();
```


**Do you have a custom event of your own?**

3. Creating a custom event of your own (is easy!)
----

1. Create your own Java class and extend `com.mcac0006.siftscience.event.domain.Event`

2. Create your private attributes and their getters and setters

3. Make sure you override and implement the equals() method. You will need it for your JUnit test (below).

4. **Recommended!** Create at least one JUnit test to make sure your class is being serialized properly. Check out `com.mcac0006.services.siftscience.SiftScienceBodyTest` to have a better idea on how this is done with the standard Event classes.

 
4. License
---
The MIT License (MIT)

Copyright (c) 2014 Matthew Cachia

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
