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

## Discussion
