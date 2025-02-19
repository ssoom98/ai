from django.db import models
class Student(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.CharField(max_length=100, unique=True)
    major = models.CharField(max_length=100, null=True)
    age = models.IntegerField(default=0)
    grade = models.IntegerField(default=1)
    def __str__(self):
        return "{}.{}({}{}학년{}살)".format(self.id,self.name,self.major,self.grade,self.age)
