Stacks

-like a stack of dishes
-LIFO Yea yea

*******************************************
using System.Collections;

-in C# everything is a an object
-have to casst item to the specific type when we remove

*******************************************
Creating an empty stack

Stack s = new Stack();

Pushing //(adding). Adds to top

s.Push(something);

popping //(remoe from top)

type elems = (type)s.Pop();

peeking //(look at top, don't remove)

type elem = (type)s.Peek(); //(stack is unchanged)

int size = s.Count;

**********************************************

reverse the letters in a word

string example = "hello";
Stack s = new Stack();

for (int i, i < example.Length; i++)
{
	s.Push(example[i]);
}

StringBuilder build = new StringBuilder();

while(s.Count > 0)
{
	char letter = (char)s.Pop();
	build.Append(letter);
}

Console.WriteLine("Reversed " + build.ToSTring());

*************************************************
Undoing text editor edits

Goals:
	1)Undo most recent editor
	2)Redo most recent undo
	
Need two stacks
	1) _editing history: all edits pushed on 
	2) _undo History: all undos pushed on
	
Course text implementation- ineffecient
*************************************************************

More effecient - each edit consists of:
	1) bool: whether edit was a deletion
	2) int: index in text that marks beginning of edit
	3) string: te string inserted or deleted
	
Also, store most recent text box contents before latest change (_lastText)

*************************************************************
example:

-Initialization
	
- Type "Hello"
	Push: false
	Push: 0
	Push: "Hello"
	
- Delete 'e'
	Push: true
	Push: 1
	Push: "e"

RecordEdit.
	-You will be calling Push 3 times
	
IsDeletion, GetEditLength, GetEditLocation, GetEditString.

*******************************************************************8
User selects undo

Need to Pop three times to get most recent change

string edit = (string)_editingHistory.Pop();
//get index (pop)
//get bool (pop)

Call Push 3 times on _undoHistory (string, index, bool)

Call DoEdit to "undo" that change
--> pass in negation of the bool (!)

*********************************************************************
User selects redo

Pop recent ndo off _undoHistory (pop 3 times)
Call DoEdit to "redo" that change

Call Push 3 times on _editingHistory



9/4

Project 1 will be posted early next week
************************************************************************
using System.Collections.Generic;

Stack<T> s = new Stack;

 ***************************************************************************
 for each loop
  
foreach (type name in collection)
{
	 
}

string example = "hello";

foreach (char letter n example)
{
	Console.WriteLine(letter);
	//letter = 'b'; Not allowed: can only access them, not change them
}


********************************************************************
Example: reverse directions

private string ReverseDirections(string dir)
{
	Stack<char> s = new Stack<char>();
	
	foreach (char turn in dir)
	{
		s.Push(turn);
	}
	
	StringBuilder build = new StringBuilder();
	
	while (s.Count > 0)
	{
		char turn = s.Pop();
		if (turn == "R")
		{
			build.Append("L");
		}
		else if (turn == "L")
		{
			build.Append("R");
		}
	}
	return build.ToString();
} 

**************************************************************
Paranthesis matching

[]{}()

Which are matched? 

(a) - matched

[a) - not mathched

(a+ [b)] - not matched

if we see a closing parenthesis we can look at the most recent on added to see if it atched

*********************************************************************
algorithem

Use a stac to push the opening parenthesis. (char)
If we see a closing one we chack

Full algorithem

creat an empty string of char

foreach through each charachter in our expression
	if char is an opening parenthesis,
		push it on the stacks
		
	else if char is a closing parenthesis
		if the stack is empty
			not matched!
		else 
			pop off opening paranthesis from stacks
			see if char, opening "match";
			
if stack is not empty 
	not matched!
else 
	matched!

*************************************************************************************
9/9

implementating a stack

storing elements in an array

Where is the top?
	the beginning 
	top = last index
	

public class Stack<T>
{
	//also keeps track of the nxt available position
	private int_size = 0;
	
	private T[] _list = new T[5];
}


push (add to top)
public void Push(T elem)
{
	//if _>= _list.Length
		//T[] bigger = new t[2*_list.Length];
		//either copy with a for-loop, or
		//Array.Copy(_list, bigger, _list.Length);
	//_list = bigger;
	//usually, add elem to _list[_size]
	//size++;
}


peek (return what is on top)

public T Peek()
{
	//if _size == 0, throw and exception
	return _list[_size-1];
}


pop (ttake off and return)

public T Pop()
{
	//if _size = 0 throw exception
	
	//will be returning _list[_size-1] (or could call Peek())
	//_size--;
}


properties

public class Person
{
	private string _name;
	private int _age;
	
	public Person(string n, int a)
	{
		_name = n;
		_age = a;
	}
	public string Name{
		get
		{
			return _name;
		}
		
		set
		{
			_name = value;
		}
	}
	public int Age
	{
		get{
			return _age;
		}
		set
		{
			_age = value;
		}
	}
	
	//Write name, Age properties
}

Person p = ew Person("Bob", 18);
string n = p.Name;
p.Name = "Fred";
int age = p.Age;



*********************************************************************
9/11

Hw 1 due Thursday

assume we can travel though any two points

How do we find the distance between two points

array of points 
arry of distances
*************************************************************************

Method to find all distances

private double [,] GetDistance(Point[] points)
{
	double[,] distances = new double[point.Length, points.Length];
	
	//nested loop through points (loop with i, inner loop with j)
		//looking at points[i], points[j]
			//find distance between those two points
			//put in your array at distance[i,j]
}

************************************************************************
Finding the minimum tour

Exmple with 4 points (p0, p1, p2, p3).


pick p0 to start 
	need to explore all of the possible paths and keep up with which one is the best
p0,p1 
	//best distance as of now is infinity 
	//current path distance 7
p0,p1,p2
	// current path distance 15
p0,p1,p2, p3
	//current path distance 17
p0, p1, p2, p3, p0
	//current path distance 22
	
the we back track

p0, p1, p2, no pther possible option
	//15
p0, p1, p3, p2
	//17
p0, p1, p3, p2, p0
	//18
	
Writing the method

private double GetMinTour(int numPoints, double[,] distances, int[] order)
{
		
}

Variables need.

bool[] visited new bool[numPoints];
visited[0] = true;
double shortestPath = Double.PositiveInfinity;

//store index of cities
Stack<int> s = new Stack<int>();
s.Puch(0);

//curr is the latest city we are considering adding to our path
int curr = 1;
double curPathLenght = 0;

********************************************************************************

What s a queue?

FIFO data structure

Operations

Enqueueing(adding)

Dequeueing(removing)

***************************************************************************

using.Systems.Collections.Generic;

Operations.

Creating a new queue

Queue<T> q = new Queue<T>();

Queue<int> q = new Queue<int>();

Enqueueing (adding)

q.Enqueue(5);
q.Enqueue(7);
q.Enqueue(3);

Peeking

int first = q.Peek(); //5 is first in line

Dequeueing (removing)

int removeFirst = p.Dequeue(); //(5is first)

Size 
int size = q.Count.

***************************************************************************
Capitol Gain

buying shares of stock at different times
different shares will have different purchase prices


sellling stock(will sell oldest stock first)
net gain/loss: for each share, (sellingPrice - purchasePrice)

for each share you enqueue the purchase prices

for selling stuff

dequeueing does the oldest prices first

net gain = 0;

	add to netGain (sellingPrice-Purchase Price)
	
	
	
**************************************************************************
9/14

Implementing a queue with a array
Need to keep track of front and back

Example:

array is size 5
 we add 5 elementswe dequeue 4
 
 when do we resize?
 enqueue 3,5
 
*************************************************************************
Fields
 
private int _front = 0;
//private int _back
private T[] _list = new t[5];
private int _ sze = 0;

********************************************************************
Enqueue

Check if arra is full (if _size = _list.Length);
	resize:
		Create a new array (bigger) that is twice as big
		Copy those elements 1) Copy strting from _front in _list into beginning of bigger
		
		
Array.Copy(fromArray, indexFrom, toArray, toIndex, numElemsToCopy)
		
		fromArray: _list
		indexFrom: _front
		toArray: bigger
		toIndex: 
		numElemsToCopy: _list.Length - _front
		
		2) copy from beginning of _list to 2nd half of bigger
		
		fromArray: _list
		indexFrom: 0
		toArray: bigger
		toIndex: _list.Length - _front
		numElemsToCopy: _front
		
		Other resize updates:
		_front = 0
		_list = bigger

		In all cases (after resizing if needed)
		put new element at index _front + _size % _list.Length
		increment _size
		
		*************************************************************
		
		Peek.
		
		if size = 0 throw invalidOperationException
		
		otherwise: 
			return element at index _front;
			
************************************************************************
Dequeue

	T elem = Peek();
	
	_list[_front] = default(T);
	_front=(_front-1)%_list.Length;
	_size--;
	
	return elem
	
********************************************************************
9/16

Linked list

_____     _____     _____
|data| -> |data| -> |data|
|next| -> |next| -> |next|
------    -----     ------


Why can they be more effecient?

*********************************************************************
public class LinkedlistCell<T>
{
	private T _data;
	LinkedList<T> _next; //recursive definition
	
	public T Data 
	{
		get
		{
			return _data;
		}
		
		set{
			_data = value;
		}
	}
	
	public T Next 
	{
		get
		{
			return _next;
		}
		
		set{
			_next = value;
		}
	}
}

***************************************************************
Example: Building a list

LinkedListCell<int> list = null;

list = new LinkedListCell<int>();
list.Data = 1;

list.Next = new LinkedListCell<int>();
list.Next.Data = 2;

LinkedListCell<int> newCell = new LinkedListCell<nt>();
newCell.Data = 3;
newCell.Next = list.Next;
list.Next = newCell;

Console.WriteLine(list.Next.Data);
*****************************************************************
Implementing a stack with a linked list

public class Stack<T>
{
	private LinkedListCell<T> _front;
	private int _size;
}

********************************************************
Count property

*****************************************************************
Push

create a new LinkedListCell (call is newCell)
set newSell.Data to be what you are pushing;
newCell.Next = _front;
new _front is newCell
Update size.

**************************************************************
Peek.

if (_size == 0)
{
	throw an exception
}
else
{
	return _front.Data
}

*************************************************************
Pop.

call peek to get he data
_front = _front.Next;
size--;
return peek.

*************************************************************

9/21

Example: method to take LinkedListCell<int>, return sum of all data

private int SumList(LinkedListCell<int> front)
{
	LinkedListCell<int> temp = front;
	int sum = 0;
	
	while (temp != null)
	{
		sum += temp.Data;
		temp = temp.Next;
	}
	
	return sum;
}

******************************************************************
Prime numbers

and integer greater than 0
only divisable by 1 and itself;

Sieve of Eratosthenes (fnd primes < n)

1) Place all numbers (2 up to n-1) in a list
2) For each number k n the list, remove ll subsequent elements
   that are divisible by k
3) The numbers left in the list are primes

Optimizations

Any non-prime m has a prme factor p where p^2 <= m
can stop step 2 when k^2 >= n.

Example, n = 25


*************************************************************
Need 3 steps

Step 1:

GetNumbersLessThan

LinkedListCell<int> front = null;
loop from n-1 down to 2;
	maek a new LinkedListCell to hold current number (set its data to number)
	the new cells next should be front (put in FRONT of list)
	front = the new cell;
	
***********************************************************
Step 2:

RemoveMultiples(int k, LinkedListCell<int> list)

removing mulitples of k AFTER first cell in list

LinkedListCell<int> temp = list;
while (temp.Next != null)
{
	check if temp.Next.Data is a multiple of k (use %)
		if it is, delete temp.Next;
		temp.Next = temp.Next.Next;
}
	temp = temp.Next; (always do this)
	
**************************************************************
GetPrimesNumbers

LinkedListCell<int> front = GetNumbersLessThan;
Use a temp cell to start at front of the list

while(temp != null && (temp.Data *temp.Data) < n)
{
	call RemoveMultiples with temp.Data, temp
	advance temp to next in list 
}



****************************************************************
9/23

Two practice exams online

Topic covered:
Stacks (with generic <T>)
Queues (with generic <T>)
LinkedListCell<T> (linked lists)
StringBuilder/string

Gui elements: TextBox, OpenFileDialog, SaveFileDialog
Basic file I/OBJECT_NOT_EXIST

Example:
//Assume list has at least one cell
public void AddSecond(LinkedListCell<T> head, T val)
{
	LinkedListCell<T> cell = new LinkedListCell<T>();
	cell.Data = val;
	cell.Next = head.Next;
	head.Next = cell;
}
	
**********************************************************************
using statements to read files

using (StreamReader sr = new StreamReader(filename))
{
	while (!sr.EndOfStream)
	{
		string line = s.ReadLine();
	}
}
//sr.Close();

**********************************************************************
NameInformation structure

Read-only prperties:
string name;
float Frequency;
int Rank;

To create:
NameInformation info - newNameInformation("bob", .05, 2);

**********************************************************************
Example: create lnked list with two cells

LinkedListCell<NameInformation> _front = null;

//Add Jane to list
LinkedListCell<NameInformation> cell = new LinkedListCell<NameInformation>();
cell.Data = new NameInformation("Jane", 0.01, 4);
cell.Next = _front;
_front = cell;

//Add Bob 
cell = LinkedListCell<NameInformation>();
cell.Data = new NameInformation("Bob", 0.05, 2);
cell.Next;
_front = cell;

Example:

search for rank of 1;

LinkedListCell<NameInformation> temp = _front;
while(temp != null)
{
	if(temp.Data.Rank == 1)
	{
		Console.WriteLine(temp.Data.Name);
	}
	temp = temp.Next;
}

**********************************************************************************
9/28

HW 2 will be posted after class today

*********************************************************************************
System.Collections.Generic.List<T>

Purpose.
Storing elements, easy resize

Creating new list
List<T> list = new List<T>();

Adding elements 
list.Add(elem);

List<string> list = new list<string>();
list.Add("Bob");
list.Add("Jane");

Inserting elements
list.Insert(1, "Fred");

Accessing elements
string name = list[1];

//
int size = list.Count;

**********************************************************************************
Performance

Add. is very effecient except for when resizin which doesn't happen often

Insert. Can be very expensive if it is closer towards the beginning 
effecient for inserting towards end 

**********************************************************************************
search
we have a list (backed by an array) we want to know the index of an element k

Linear search
Start at beginning, compare each element until end

Search on sorted lists (smallest to biggest)

Could at least stop searching when we reached an element bigger than k
********************************************************************************
Binary search

Thinking of number from 1-100.

Algorithm.

start = 0
end = length of list

while (??)
{
	mid = (start+end)/2
	compare list[mid] and k (element I'm searching for)
	1) if list[mid] == k, found k! 
	2) if list[mid] < k, adjust start (start = mid+1)
	3) if list[mid] > k adjust end
}

If we leave loop, we never found k

CompareTo.
== yes for strings
<, > nor for strings

if(strl.CompareTo(str2) < 0)
{
	//means string 1 comes alphabetically before str2
}

Performance (our list has n elements)

Linear search, worst-case: all n elements
Binary search, worst-case: log_2 n elements

n = 1,000,000
log_2 1,000,000: 19.931
n = 1,000,000,000 
log_2 1,000,000,000: 29.897

********************************************************************
9/30

Linear structures

-sorted array
	Search: binary search
	Insert: ineffecient to add at beginning
	Delete: ineefecien to delete from beginnging

-linked list (sorted)
	Search: worst-case, have to look at all elements
	Insert: effcient (no shifting)
	Delete: same as above

**********************************************************************
Trees (non-linear structure)

Definition: 
if non-empty, a tree has:

	a root
	0 ot more children, which are also trees

************************************************************************
Example: file system

Root: a folder. contains data files.
Children: sub folders

How to calculate the size of a folder?
	-add up the size of all of the data files
	-get names of all subfolders
	-do this with recursion
	
**********************************************************************
recursion  method that includes a call to itself

Base case. We immediatly know the answer, no more work needed.

Recursive case: we process the current level, recursively process all children 
	(or the rest of the data)

	
*********************************************************************
Example: recursion on a linked list

pubblic int SumUp(LinkedListCell<int> front)
{
	if (front == null)
	{
		return 0;
	}
	else 
	{
		int data = front.Data;
		int other = SumUp(front.Next);
		return data + other;
	}
}

*****************************************************************************
System.IO.DirectoryInfo

(Given parameter DirectoryInfo folder, return sum of total folder size)

DirectoryInfo[] subFolders = folder.GetDirectories();
FileInfo[] files = folder.GetFiles();

long size = (some FileInfo).Length

****************************************************************************
Algorithm to find folder size

prarmeter: DirectoryInfo folder

-get all sub folders
-get all files

********************************************************************************
10/5

Out parameters

- A form of call-by-reference parameters
- Allow two returned values of two numbers

//return: product
//sum: out parameters

public int SumAndProduct(int a, int b, out int sum)
{
	sum = a+b;
	return a*b;
}

Calling the method:
int x =3;
int y = 4;
int result;
int prod = SumAndProduct(x, y, out result);

**********************************************************************************
Remove from binary seach tree.

NO children of element to remvce: just get rid of children 
Only one child: move it up
Both children: find miin from right(or left) sub tree, 
			   remove it from right sub tree
			   That min element becomes new root
				

(name is what we want to remove, t is tree)
Parameters: string name BinaryTreeNode<NameInformation> t,
			out bool removed
			
returns: updated tree with name removed

(**removed MUST be updates to true or false as well**)

(First we nee to FIND the node with the nae we want to remove)
If t is empty
	that name is not there
	removed = false;
	return null; (the tree is still empty)
If t.Data.Name equals that anem you are trying to search for
	//we found it and now have to remove item
	
	removed = true;
	//if left and right are null
		return null(updated tree)
	//if it right has one child;
		return left child
	//if it only has left child
		return right child
	//if it has both left and right children
		newData = smallest from right sybtree (make sure that this is removed)
		newLeft = t.LeftChild;
		newRight = t.RightChild (but make sure the min was removed)
		creat/return new tree with these values
		
If t.Data.Name > name
	//go to left
	newLeft = Remove(name, t.LeftChild, out removed);
	newRght = t.RightChild
	newData = t.Data
	return new BinaryTreeNode<NameInformation>(newData, newLeft, newRight);
If t.Data.Name < name 
	// go to right
	
	

***********************************************************************************
Remove/return smallest element

Parameters: BinaryTreeNode<NameInformation> t, out NameInformation min

Returns: updated tree after removing min

Where is the min value in a tree?
	All the way left
	
if t.LeftChild is empty
	min = t.Data
	return t.RghtChild as the updated tree with min removed
else 
	recursively call method to the left

(**min MUST be updated )


*******************************************************************************
StreamWriter

using (StreamWriter sw = new StreamWriter(filename))
{
	sw.WriteLine(stuff);
	***can use is as many tmes as needed
}

*********************************************************************************
Inorder traversal. (in a binary dearch ree, will print data in sorted order)

algorithm

if tree is empty, do nothing
else 
	recursively process the left subtree
	Print/process the root data
	Recursively process the right sub tree
	
	arithmatic expressions 
	2+3 is called inFix notation
	2 3 + post order notation

**********************************************************************************
Preorder traversla

if tree is empty, do nothing
else 
	Print/process the root data
	recursively process the left subtree
	Recursively process the right sub tree
	
Post order traversal

if tree is empty, do nothing
else 
	recursively process the left subtree
	Recursively process the right sub tree
	Print/process the root data
	
**********************************************************************************
Lab: lab implement inorder traversal to print data to a file in soted order
private void WriteData (StreamWriter sw, BinaryTreeNode<NameInformation> t)
{
	if tree is empty, do nothing
else 
	recursively process the left subtree
	Print/process the root data
		print to the output file
			name
			frequency
			rank
	Recursivelt process the right sub tree
}

*********************************************************************************
10/9

Binary search tree effeciency

Insert/search/remove

n nodes in a balanced tree

log n nodes to look at.

**************************************************************************
height of a binary search tree

Empty tree: heht is -1
Non-empty tree is 1+ max (left subtree height, right subtree height)

A tree is balanced if the left and riht subtree hieght is no more than one.
 ~if one is 1 an the other is -1 it is not balanced
 ~if one is 1 and the other is 0 then it is balanced

**************************************************************************
AVL tree: a binary searvh tree that is balanced(b the definition above)

************************************************************************
Single rotate right:
left child height is 2 greater that right child heigt, AND
left.left.height > right.left.height

*************************************************************************
Single rotate left:
riht child height is 2 greater that left child heigt, AND
right.right.height >= right.left.height

*************************************************************************
Double rotate right
left child height is 2 greater that right child height, AND 
left.right.height >= left.left.height

*************************************************************************
Double rotate left: 
right child height is 2 greater that left child height, AND 
right.left.height >= right.right.height

************************************************************************
Single rotate right code

private static BinaryTreeNode<T> SingleRotateRight(T root, BinaryTreeNode<T> left, BinaryTreeNode<T> right)
{
	BinaryTreeNode<T> newRight = new BinaryTreeNode<T>(root,left.RightChilde, right);
	return new BinaryTreeNode<T>(left.Data, left.LeftChild, newRight);
}

SIngle left
similar
look at pictures

*************************************************************************
Implemeting double rotations

T root = ??;
BinaryTreeNode<T> newLeft = new BinaryTreeNode<T>(...);
BinaryTreeNode<T> newRight = new BinaryTreeNode<T>(...);

return new BinaryTreeNode<T>(newRoot, newLeft,newRight);

***********************************************************************
Height method/field/property

Math.Max(first, second)

Height method (static, class.method)
	will take a BinaryTreeNode<T> as a pramater
	will return its height
		if the param is null return -1
		else, return the parameters height property
		
**********************************************************************
GetlAvlTree method

From userInterface, all code tht did
" = new BinaryTreeNode<NameInformation>(...)"

replace with:


**********************************************************************
HW 3 due tuesday 

Search tree

Search algorithm
curPoint (where we are in a particular tour)
(it will start at 0)

loop though all of the other points	
	if a point is unvisited in the current path
		make a recursive call with that point as your curPoint
		

Parameters
intCurPoint - keeps track of the current point (like a node in a search tree) in current tour
doubl pathLenToCur - length of the current tour from 0 to curPoint 
					(distance traveld from start to current point alonf the current path)
bool[] visited - marks which points have been visited in the current path
double[,] distances - distances between any two points (same as hw 1)
int pointsInCurPath - how many point that have been included in a partcular path
double minTour - the length of the shortest path 
**out LinkedListCell<int> bestTourFinish** -

Return values from mathods
1) out LinkedListCell<int> bestTourFinish
	
2) double (the total tour distance following the current path to curPoint {pathLenToCur}
				+ the length of the path in bestTourFinish)
				
Seach method:
1) Check pointsInCurPath. 
	If it contains all the points:
		compute the total toue length (pathLenToCur + distance back to start)
		bestTourFinish: a single node with curPath in it
		
2) if MintTour < pathLenToCur (and we haven't used all points yet)
	stop the search (no recursive calls)
	
3) else (general case)
	for each unvisited point (index) (check visted array)
	visit it
	recursive call on that point
	
keep track of the best path distance/linkedlist returned from recursive call
				
***************************************************************************************
Trie. Specifically for representing a dictionary

Example.
ape
apple
cable
car
cart
cat
cattle
curl
farm

************************************************************************************
trie class

public class Trie
{
	private bool _wordEndsHere = false;
	private Trie[] _children = new Trie[26];
	
	public bool Contains(string s)
	{
		if s is empty, return my bool (_wordEndsHere)
		else if s[0] < 'a' or > 'z' return false;
		else 
			int index = s[0] - 'a'
			if child at that index is still null, return false
			else 
				string rest = s.Substring(1);
				recursively search rest on child at that index
	}
	
	public void Add(string s)
	{
		if s s empty, set _wordEndsHere to true
		else if s[0] < 'a' or > 'z' throw new ArgumentException
		else
			int index = s[0] - 'a'
			if child at that index is still null
				create a new Trie object to store at that index
				
			string rest = s.Substring(1);
			recursively add rest to child at that index
	}
}



***************************************************************************
10/14

EC 

****************************************************************************
Interface

- an interface is like a class, but it onlt contains method headers

Example: IShape
- number o edges
- area
- perimeter 

(in a file called IShape.cs)

public interface IShape
{
	int NumEdges();
	
	double Area();
	
	double perimeter();
}

IShape sh = new IShape(); //doesn't make any sense to do this you can't call any methods
//can make a variable, but not an object of that type

**************************************************************************
Implementing an interface.
Example: Rectangle

public class Rectangle : IShape
{
	private Rectangle 
	{
		private double _length;
		private double _width;
	}
	//must include methods from interface
	public int NumEdges()
	
	int NumEdges();
	
	double Area();
	
	double perimeter()
	{
		return 2*_width + 2*_length;
	}
}

IShape shape = new Rectangle(3,4);

double area = shape.Area();


************************************************************************
ITrie interface

public interface ITrie
{
	bool Contains(string s)
	{
		ITrie Add(string s);//return updated trie 
	}
}

Three kinds of tries
TrieWithNoChildren: a lead in out trie (no letters come after)
TrieWithOneChild: exactly one letter (node) comes after us
TrieWithManyChildren: more than one letter comes after us, store all 26 possible children

************************************************************************
TrieWithOneChild

Fields.
bool _wordEndsHere;
char _letter;
ITrie _child;	

Constructor.
public TrieWithOneChild(string s, bool wordHere)
{
	//if word is empty 
		throw exception (this trie should have a child)
	//if 1st letter in s is not lower-case
		throw exception
	
	_letter = s[0];
	set bool field to our bool parameter;
	_child = new TrieWithNoChildren();
	update _child to be the result of adding s.Substring(1) to _child
	
	_child = _child.Add(s.Substring(1));
}
**************************************************************************
TrieWithNoChildren: Add
 
//if the word to add is empty
	set the bool to true;
	return this;
//else 
	create/return new TrieWithOneChild(which will add the word)

*************************************************************************
TrieWithOneChildren: Add

//if word is empty
	set bool to true;
	return this;
//else if 1st letter in word to add matches _letter
	update _child to be the result of adding the rest of the word to _child 
	return this;
//else 
	create/return new TrieWithManyChildren

***************************************************************************
TrieWithNoChildren: Contains

if word is empty
	return bool
else
	return false;

************************************************************************
TrieWithOneChild: Contains

if word is empty
	return bool
else if 1st letter matches our _letter
	recursively search out child with rest of string
else
	return false;

******************************************************************************
10/16

Lab goal: printing our all of the words that begin with acertain prefix

How would we do that?

******************************************************************************
ITrie interface adds two methods 

ITrie GetCompletions(string prefix)
{
	
}

void AddAll(StringBuilder prefix, IList list)
{
	
}

*These wil need to be added for all three kinds of tries
*****************************************************************************
Psuedo Code:
GetCompletions, No Children

if (prefix == "")
{
	return this;
}
else 
{
	return null; //nothing matches that prefix
}

********************************
GetCompletions, Many Children

if (prefix == "")
{
	return this;
}
else
{
	get index of 1st letter in prefix
	if (child != null)
	{
		recursively get completions on that child for the rest of the prefix
	}
	else
	{
		return null// nothing else matches
	}		
}

**************************************************
AddAll, no children

if (bool == true)//I represent a word
{
	add prefix to list
}

*******************************************
AddAll, Many Children

if (bool == true)
{
	add prefix to list
}
for each (non-null child)
{
	add its letter to prefix ((chsr) (i+'a'))
	recursive call on that child with the updated prefix
	prefix.Length--;
}

***********************************************
User Interface modification

1) get trie of completions of prefix entered by userInterface
	(will give you back a result trie)
2) Make a StringBuilder out of the prefix


******************************************************
10/19

Exam 2 is Wednesday

Covers: linked lists, lists, binary search trees, tries

Practice exams are online
Review Problems

//#3 inside Trie class (original version, like ManyChildren implementation)
public int CountWords()
{
	int count = 0;
	
	if(_hasEmptyString)
	{
		count++;
	}
	for(int i =0; i< _children.Length; i++)
	{
		if (_children[i] != null)
		{
			
		}
	}
}


*******************************************
Lab Today: Find all possible words on a Boggle bored

Idea: 

Get a trie of all dictionary words 
Loop through each possible sarting die
	buld prefix (and corresponding trie on completions)
	if a prefix is a word: record it!
	From  particular position extend search
		recursively to adjust dice
		
*********************************************************
Parameters.
row/col of current die
bool[,] used (which are used on a current path)
StringBuilder prefix - letters along a current path
ITrie completions = portion of dictionary trie by following prefix
ITrie found - all words found

Return. - trie of all words found 

***********************************************
Algorithm.

1) From the trie on completions, find the trie of completions 
	of the string on the current die
	
	completions = completions.GetCompletions(letter on the current die);
2) if (completions == null);
	{
			return found;
	}

3) Mark the current die as used (use row,col) 
	Append the string on the current die onto prefix
	
4) If completions contains "", prefix is a wod
	found - found.Add(prefix.ToString());
	
5) Recursively add all words on unused adjacent dice (more later);

6) Remove last letter from prefix (decrement length);
	Mark that dice as unused;
	Retrun the words found
	
Recursive step (#5):
	Use nested loops to loop through adjacent dice
		int rowStart = Math.Max(0, row-1);
		int rowUpTo = Math.Min(row+1, 3);
		
	//do th same thing with column
		for (int i = rowStart; i <= rowEnd; i++)
		{
			//if that [i,j] is unused
			found = (recursive call)
				pass: i/j for current die, used, prefix, (updated)completions, found
		}