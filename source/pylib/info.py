class Cal:
    def  __init__(self,num1 = 1, num2 = 1):
        self.num1=num1
        self.num2=num2
    def add(self):
        return self.num1+self.num2
    def sub(self):
        return self.num1 - self.num2
    
def main():
        print('Cal 객체 생성 test')
        obj = Cal(10,20)
        print('obj.num1 :', obj.num1)
        print('obj.num2 :', obj.num2)
        print('add test :', obj.add())
        print('sub test :', obj.sub())

if __name__=='__main__':
    main()