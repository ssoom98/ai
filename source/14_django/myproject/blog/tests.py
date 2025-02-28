from django.test import TestCase
import re
# 38.5,125.4125   38,128
value = input('경도,위도 ?')
if not re.match(r'(\d+\.?\d*),(\d+\.?\d*)', value):
  print('경도,위도 포맷으로 입력 안 했네')
