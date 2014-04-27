sift-java
=========

Java library which help integrate your Java application to Sift Science (http://www.siftscience.com) quicker and easier.

This library has been made using Apache HttpClient (http://hc.apache.org) and Jackson JSON Processor (http://jackson.codehaus.org).

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
// Sending a Transaction is easy!
final Event event = new Transaction(); // create an event
event.setX(...).setY(...).setZ(...); //fill in all fields using setters
final SiftScienceResult ssr = helper.send(event); //send the event to SiftScience
```

```
// Labels are also created in the same fashion
final Label label = new Label(); // create an event
label.setX(...).setY(...).setZ(...); //fill in all fields using setters
final SiftScienceResult ssr = helper.send(event); //send the event to SiftScience
```

3. This project is far from complete!
---------------

Naming a few things which are left to be implemented:
- support for Scores API
- support for custom events
- support for custom fields

*Would you like to contribute?*

 
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