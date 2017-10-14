class Node:
	
	def __init__(self):

		self.parent=None
		self.left=None
		self.right=None
		self.start=-1
		self.end=-1
		self.val=0


class SegmentTree:

	def __init__(self,n):

		self.n=n-1
		self.root=None

	def design(self,s,e):

		
		x=Node()
		x.start=s
		x.end=e

		if e==self.n and s==0:
			self.root=x


		if s==e:
			return x

		else:
			m=int((s+e)/2)
			p=self.design(s,m)
			q=self.design(m+1,e)

			p.parent=x
			x.left=p

			q.parent=x
			x.right=q

		return x

	def sear(self,x,i,j):

		if x==None:
			return
		if x.start==i and x.end==j:
			return x

		else:
			p=self.sear(x.left,i,j)
			q=self.sear(x.right,i,j)
			if p!=None:
				return p
			if q!=None:
				return q
				

	def insert(self,a):

		n=len(a)

		for i in range(0,n):

			t=self.sear(self.root,i,i)
			t.val=a[i]

	def summing(self):

		for i in range(0,self.n+1):
			for j in range(i+1,self.n+1):

				for p in range(j-1,-1,-1):
					t=self.sear(self.root,p,j)
					if t!=None:
						t.val=t.right.val+t.left.val

				t=self.sear(self.root,i,j)

				if t!=None:
					t.val=t.right.val+t.left.val

				k=self.n-j
				t=self.sear(self.root,k,self.n)

				if t!=None:
					t.val=t.right.val+t.left.val

	def traversal(self,x):

		if x==None:
			return

		else:
			print(x.val)
			self.traversal(x.left)
			self.traversal(x.right)

	def intraversal(self,x):

		if x==None:
			return
		else:
			self.intraversal(x.left)
			print(x.val)
			self.intraversal(x.right)

	def rangesum(self,x,s,e):

		if s==x.start and e==x.end:

			return x.val

		elif (x.start<s and e<=x.end) or (s>=x.start and e<x.end) :

			p=0
			q=0

			if x.left!=None:
				if x.left.end>=s:
					if e<x.left.end:
						q=self.rangesum(x.left,s,e)
					else:
						q=self.rangesum(x.left,s,x.left.end)
			if x.right!=None:
				if x.right.start<=e:
					if s>x.right.start:
						p=self.rangesum(x.right,s,e)
					else:
						p=self.rangesum(x.right,x.right.start,e)
			
			return p+q

		elif x.start<s<x.end or x.start<e<x.end:

			p=0
			q=0

			if x.left!=None:
				if x.left.end>=s:
					q=self.rangesum(x.left,s,x.left.end)
			if x.right!=None:
				if x.right.start<=e:
					p=self.rangesum(x.right,x.right.start,e)
			

			return p+q

		else:

			return 0

	def update(self,i,n):

		t=self.sear(self.root,i,i)
		k=n-t.val
		self.add(self.root,t.start,t.end,k)

	def add(self,x,s,e,k):

		if s==x.start and e==x.end:

			x.val=x.val+k

		elif (x.start<s and e<=x.end) or (s>=x.start and e<x.end) :


			if x.left!=None:
				if x.left.end>=s:
					if e<x.left.end:
						x.val=x.val+k
						self.add(x.left,s,e,k)
					else:
						x.val=x.val+k
						self.add(x.left,s,x.left.end,k)
			if x.right!=None:
				if x.right.start<=e:
					if s>x.right.start:
						x.val=x.val+k
						self.add(x.right,s,e,k)
					else:
						x.val=x.val+k
						self.add(x.right,x.right.start,e,k)

		elif x.start<s<x.end or x.start<e<x.end:

			if x.left!=None:
				if x.left.end>=s:
					if e<x.left.end:
						x.val=x.val+k
						self.add(x.left,s,e,k)
					else:
						x.val=x.val+k
						self.add(x.left,s,x.left.end,k)
			if x.right!=None:
				if x.right.start<=e:
					if s>x.right.start:
						x.val=x.val+k
						self.add(x.right,s,e,k)
					else:
						x.val=x.val+k
						self.add(x.right,x.right.start,e,k)

class TrainSchedules:

	def __init__(self):

		self.T=tr()
		self.T.time=SegmentTree(9)
		self.T.distance=SegmentTree(9)

		self.Stops=[]
		self.times=[]
		self.distances=[]

		self.name=None
		self.no=None

	def build(self):

		self.T.time.design(0,8)
		self.T.time.insert(self.times)
		self.T.time.summing()

		self.T.distance.design(0,8)
		self.T.distance.insert(self.distances)
		self.T.distance.summing()


	def intro(self):

		

		print('Train Name:			',self.name,'\n')
		
		print('Train Number:		',self.no,'\n')
		print('Starting Station:	',self.Stops[0])
		print('Final Station:		',self.Stops[-1],'\n')
		print('Route List:\n')
		n=len(self.Stops)
		for i in range(0,n):
			print(i+1,'.',self.Stops[i])
		print('\n')

	def Time(self,i,j):

		s=self.T.time.rangesum(self.T.time.root,i,j-1)
		return s

	def Distance(self,i,j):
		s=self.T.distance.rangesum(self.T.distance.root,i,j-1)
		return s

	def upTime(self,n,k):
		self.T.time.update(n,k)

	def upDistance(self,n,k):
		self.T.distance.update(n,k)
	
class tr:

	def __init__(self):

		self.time=None
		self.distance=None


def main():

	n=2
	names=['Mangalore Central Malabar Express','Poorna Express					']
	nums=['16630','11097']
	Train=[]
	for i in range(0,2):

		Train.append(TrainSchedules())
		Train[i].name=names[i]
		Train[i].no=nums[i]
	
	Train[0].Stops=['Mangalore','Ullal','Manjeshwar','Uppala','Kumbala','Kasaragod','Koticulum','Bekal-Fort','Kanhangad','Nileshwar']
	Train[0].times=[20,8,7,14,11,12,7,9,13]
	Train[0].distances=[9,8,7,10,12,10,5,8,10]
	Train[0].build()

	Train[1].Stops=['Pune Junction','Karad','Miraj Junction','Belgam','Castle Rock','Madgon','Gokarna Road','Murudeshwar','Udipi','Mangalore Juncton']
	Train[1].times=[180,120,140,150,185,93,58,54,107]
	Train[1].distances=[204,76,137,75,93,133,82,135,81]
	Train[1].build()


	print('*********** Welcome to South Western Railway Zone ************\n')
	print('Trains provided :\n\nTrain name          Train Number')

	for i in range(0,n):
		print(i+1,'.Train Name:	',names[i],'		',nums[i])

	c=int(input('Select Your Train\n'))-1

	Train[c].intro()
	k=int(input('Choose Your Module:\n\n1.Passenger Module\n2.Administrative Module\n'))

	if k==1:

		while 1:

			s=int(input('Enter the starting station.no:	'))
			e=int(input('Enter the ending station.no:	'))

			h=-1

			t=Train[c].Time(s-1,e-1)
			d=Train[c].Distance(s-1,e-1)
			m=t%60
			h=int(t/60)

			if h>0:
				print('The Train takes ',h,' Hours ',m,' Minutes, ',d,'kms\n')
			else:
				print('The Train takes ',m,' Minutes, ',d,'kms\n')
			p=0
			p=int(input('Do you want to take a ticket and exit the Passenger Module?\n1.Yes\n2.No\n'))
			if p==1:
				f=int(input('Enter number of people:'))
				r=(0.5*d)+(0.90*t)
				print('**********************************\n')
				print('Starting point:	',Train[c].Stops[s-1])
				print('Ending point:	',Train[c].Stops[e-1],'\n\n')
				print('Your intermediate stations:')
				for i in range(s-1,e-1):
					print(Train[c].Stops[i])
				print('Bill:			Rs.',r)
				print('**********************************\n\n')
				print('Thank You for using the South Western Railways\n\n***** Have a Happy Journey *****\n')

				break

	if k==2:

		while 1:

			p=int(input('Choose your operation:\n1.Update delay timings at a station\n2.Change a stop'))
			if p==1:

				s=int(input('enter the station number'))
				u=int(input('enter the new travel time'))
				Train[c].upTime(s-1,u)

			if p==2:

				s=int(input('enter the station number'))
				na=input('enter new station name')
				di=int(input('enter new station distance'))
				u=int(input('enter the new travel time'))
				Train[c].Stops[s-1]=na
				Train[c].upDistance(s-1,di)
				Train[c].upTime(s-1,u)

			t=int(input('Do you still want to continue in the Administrative Module:\n1.Yes\n2.No\n'))

			if t==2:
				print('***South Western Railway zone offers sincere regards for your service***\n\n        Have a nice Day...!!!!')
				break


if __name__ == '__main__':
	main()
