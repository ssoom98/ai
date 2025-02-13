from django.test import TestCase
# Create your tests here.
words = ['홍','홍','화이팅','딴거','홍']
words_dic = dict() # 빈딕셔너리
print(words_dic.keys())
for word in words:
  if word in words_dic.keys(): # words_dic['홍']
    words_dic[word] += 1 # {'홍':3}
  else:
    words_dic[word] = 1 # {'홍':1, '화이팅':1, '딴거':1}
# print(words_dic.items())
for word, cnt in words_dic.items():
  print(word, ":", cnt)