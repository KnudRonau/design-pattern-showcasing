# Project
## Environment & Tools
Operating System: Windows 10 Pro   
Git version: 2.33.1  
IDE: intelliJ IDEA 2021.1.2
Apache Maven: 3.6.3   
Java version: OpenJDK 16

## Purpose
The purpose of this assignment is to create a program which fulfills a set of requirements, which vary depending on the grade goal. As I am aiming for Am the purpose is to fulfill the following requirements: 
- Some form of input to the GUI should trigger events
- A minimum of 5 concurrent processes
- A minimum of 3 synchronized processes
- A minimum of 6 different Swing components
- A minimum of 4 different Swing layouts
- Implementation of the design patterns Object pool, Observer, Producer/Consumer, Template Method, Factory Method and Abstract Factory
- Usage of the Streams API

## Procedures
As my imagination was extraordinarily limited when planning this project, I decided to create a program whose purpose is directly showcasing implementations of the requirements needed for grade A. This meant that I would create implementations of each of the design patterns, and have these connected to a GUI, having this acting as a client for the various patterns and methods. 

As 4 different layouts were required, I started by creating the ``MainFrame``, which was divided using ``BorderLayout``, and added panels to west, north and east. I added a ``FlowLayout`` to the north panel, a ``GridLayout`` to the east panel and filled these with meaningless labels in order to show usage of various layout managers. I set the west panel to be managed by a ``BoxLayout`` and filled it with some dummy buttons, which were later when functional buttons started being added after implementing design patterns. To the ``CENTER`` of the Frame, I put a ``JTextArea``, which serves the purpose of presenting information retrieved when triggering various design patterns and when showcasing ``stream()`` usage.

After setting up an initial JFrame, The Object Pool pattern was implemented. This was done as simple as possible, with a ResourceManager Initializing 10 resources, adding these to a ``Deque`` and providing an interface for retrieving and returning these. As the purpose of this Object Pool merely is to demonstrate a way to implement the Object Pool Pattern, the Resource doesn't have any functionality other than printing that it is in use. Lastly ``ObjectPoolThread`` was implemented, which runs in a loop after being started, gets a resource, "uses" it by calling its ``useResource`` method, sleeps and returns the resource. 

Next up the Producer/Consumer pattern was implemented. In a similar fashion, the ``PCResourcePool`` adds 100 resources, which in this case are objects of the extremely simple class ``PCResource``, to the ``BlockingQueue`` resource pool. Methods to add and remove resources are ``Synchronized`` in order to make this process atomic. These methods are called by the ``Consumer`` and ``Producer`` threads which were implemented afterwards. Additionally an ``Informer`` was added, whose sole purpose is to print the number of resources currently in the pool, so that it is possible to see the progress. 

Afterwards the class ``Engine`` was introduced and received the responsibility of starting the threads from both patterns, when the ``Main`` method calls ``Engine.start()``.

The Template method pattern was created to be as simple as possible, having two classes extend the abstract class ``TemplateDemo``. These have differing implementations of some methods, while they share some from the super class. After implementing these classes, two button were added to the west panel in ``MainFrame`` which acts as a button panel. These buttons set the textArea to the return from the method ``OutputInfo`` from each class, ultimately acting as the client for the pattern.

By implementing simple Interfaces called Observer and Observable, and creating classes which implemented these, the Observable pattern was created. In this implementation I went with ``RadioShow`` as my Subject and ``RadioUnit`` as Observer. In this case, when the Observers' ``update`` method is called by the ``update`` mehtod in the Observable, all the Observers print a Radio broadcast along with the device it's played on. This update call is triggered by another button added to the GUI.

For implementing the Factory Pattern, I decided to create a Factory, which creates announcements. Both the interface and the concrete announcements are simple in this aspect. As for the ``GetAnnouncementFactory``, I went for a solution where an Announcement would be created and returned based on a matching String. This permitted me to add a ``JTextField`` to the south panel, which would have real functionality. This JTextFields sends its text as argument to the ``getAnnouncement()`` method, and returns an announcement if any matches, whose text is set to the textArea. 

While creating the ``JTextField``, I also created a ``JList`` and a ``JPasswordField`` to add to the south panel as well. This was done solely in order to ensure that I had used enough different ``JComponents``. The passwordField has a bit of functionality, in that it displays the password you input, so not something you would ever use.

For the Abstract Factory pattern I wanted to create two factories which made both a Premium and a cheap toy. As these toys were too similar, I changed it so that they both made a toy and a sofa. I have since realized that it would logically make much more sense simply to have two furniture factories who both created two different types of furniture, however as Ikea is superior to Danish Jysk, I felt I needed to add Lego, which is superior to any Swedish toy. In most real use cases all of these products would be created very differently, most likely having the values stored as attributes, having these values set upon construction. However, as this implementation's focus is upon the pattern, I figured the products should simply return information directly from the methods. 4 buttons were lastly added to the button panel in the GUI, one for each of the possible products, which add the products to the textArea.

I didn't come up with a natural way to implement any ``stream()`` usage, so I ended up creating a ``Person`` class with a few different attributes. From This I created 10 person objects in the ``PersonFilter`` class and stored them in a List to make various ``stream()`` actions possible. 

I figured 4 different ``stream()`` operations were enough to showcase my comfort using it. ``sorted()``, ``max`` and ``filter`` seems to be some of the most used operations, which is why I chose to show these in use. Additionally I created some helper methods for turning the lists into Strings, so that the persons could easily be shown in the GUI, when the various methods were called by the client.

## Discussion
Fist of all, a quick guide to using the program:  
Once started, you'll notice some prints. These relate to the Object Pool Pattern and the Producer Consumer Pattern, and occur when an Object Pool Resource is being used, or when the ``Informer`` prints the current amount of resources in the Producer Consumer Resource Pool. The GUI is rather straight forward. The buttons to the left trigger the various implemented patterns, and as a result alters the textArea. The only exception here is the "Do a radio broadcast!" button, which causes the observers to print their broadcasts. By entering either "sale", "warning" or "closing" in the ``JField`` in the bottom, an ``Announcement`` will be returned and its message will be added to the textArea.

To the best of my knowledge the purpose has been fulfilled. As described earlier, all of the different requirements have been thoroughly been implemented one by one. Naturally, this is not the most inspiring solution, but I feel like it serves the purpose of showing my understanding of the various rather explicitly. 

As mentioned in the procedures part, the Abstract Factory would have made more sense if the two products had at least been somewhat related, but for this implementation it is not a problem that toys and sofas are rarely made on the same factory. 

The Factory method is rather straight forward, with a Factory responsible for creating and returning an  object from a concrete class, which extends a given interface. 

The Object Pool can be implemented in a plethora of different ways.In the end, it's all about using resources and returning them again. This could also have been done with a button click triggering an event to get the resource, use it and then return it afterwards. 

The Observer Pattern was also rather simple, since it's just a one to many relationship between some objects, where the Observable store multiple Observers in a list, and the Observers store the Observable as an attribute. This attribute isn't doing anything in my implementation, as it is rather simple, but in a case where the Observable calls its ``update`` or ``notifyObservers`` method and observers need to access some current state or other information from the Observable, it needs to have an Observable stored. Additionally I could have created different classes implementing the Observer interface, but it didn't feel necessary. 

The Producer/Consumer pattern naturally needed some focus as there multiple threads trying to access the same pool of resources. To avoid any problems with the resource pool, all the methods are ``synchronized`` and the resource pool is a ``BlockingQueue<>``. When the program is started 1 ``Prooducer``, 1 ``Informer`` and 3 ``Consumers`` are started in order to showcase multiple concurrent processes trying to access the same resources. This is done from the class ``Engine`` which I decided to add as I thought it best not to do these tasks directly in the ``Main()`` method in ``Project``. This way ``Project`` is only responsible for starting the ``MainFrame`` and calling ``Engine.start()``. 

It took some time, but in the end I think I got the hang of using ``stream()``. In this case it's primarily used for filtering through the list, as I figured it was the simplest way to showcase some of its features. In this regard it reminds me a bit of SQL queries in that you can be rather specific in what you want returned at the ``Collecters.tolist`` simply leaves you with your desired filtered list. Many more ``stream()`` methods could have been added, but I didn't want this aspect to overshadow either.

It is hard to argue that the GUI looks particularly good. It's actually somewhat ugly. This is of course a product of the requirement oriented work strategy with focus on using the required number of ``JComponents`` and LayoutManagers. However, I would argue that GUI will never end up pretty when using Swing. Additionally, as far as I know it's exceedingly rare to use Java for GUIs in the real world, which is why I'm okay with it not being pretty as long as I understand how it works. 

As with most of these kinds of projects, I feel like I have learned a great deal, both in regards to code writing, and especially regarding the more abstract aspects of Object Oriented Programming.