def check(func):
    def wrapper():
        print(func.__name__, '함수 전처리')
        func()
        print(func.__name__, '함수 후처리')
    return wrapper
@check # 데코레이터
def hello():
    print('Hello')
@check
def world():
    print('world')

if __name__=='__main__':
    hello()
    world()
# def hello():
#     print('HELLO')
# def world():
#     print('WORLD')
# trace_hello = check(hello)
# trace_hello()
# trace_world = check(world)
# trace_world()







