from django.db import models
import re
from django.forms import ValidationError
REGION_CHOICE = (
  ("Europe","유럽"),
  ("Asia","아시아"),
  ("Africa","아프리카"),
  ("Oceania","오세아니아"),
  ("America","아메리카"),
)
def lnglat_validator(value):
  if not re.match(r'(\d+\.?\d*),(\d+\.?\d*)', value):
    raise ValidationError('Invalid LngLat. ex:38,125')
class Tag(models.Model):
  name = models.CharField(max_length=50, unique=True)
  def __str__(self):
    return self.name

class Post(models.Model): # 테이블명 : blog_post
  # id = models.AutoField(primary_key=True) PK가 없을 경우 자동 생성
  title = models.CharField(verbose_name="제목",
                           max_length=100) # 최대 길이 반드시 지정 VARCHAR 타입
  content = models.TextField("본문") # 최대 길이 제한이 없음 CLOB, TEXT 타입
  create_at = models.DateField(auto_now_add=True)
  update_at = models.DateTimeField(auto_now=True)
  region = models.CharField(verbose_name="지역",
                            max_length=20,
                            choices=REGION_CHOICE,
                            default='Asia')
  lnglat = models.CharField(verbose_name="경,위도",
                            max_length=100,
                            blank=True,
                            null=True,
                            help_text="경도,위도 포맷",
                            validators=[lnglat_validator]) # 38.5,125.4125
  url = models.URLField(blank=True, null=True)
  tags = models.ManyToManyField("Tag")

  def __str__(self):
    return "제목:{} - {}작성, {:%Y-%m-%d %p %I:%M:%S} 최종수정".format(self.title,
                                                               self.create_at,
                                                               self.update_at)
  class Meta:
    ordering = ['-update_at']

class Comment(models.Model):
  # id = models.AutoField(primary_key=True)
  post = models.ForeignKey(to=Post, # "Post"
                           on_delete=models.CASCADE)
  author = models.CharField(verbose_name="이름", max_length=20)
  message  =models.TextField(verbose_name="댓글")
  create_at = models.DateField(auto_now_add=True)
  update_at = models.DateTimeField(auto_now=True)
  def __str__(self):
    return "{}({}작성)".format(self.message, self.author)
  class Meta:
    ordering = ['-create_at', '-update_at']













