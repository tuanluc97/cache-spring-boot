package app.tuanluc.service

import app.tuanluc.service.entity.Student
import groovy.transform.CompileStatic
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@CompileStatic
class StudentService {
   @Cacheable(value = "student", key = "#id")
   Student getStudentByID(String id) {
      try {
         System.out.println("Going to sleep for 5 Secs.. to simulate backend call.")
         Thread.sleep(1000 * 5)
      }
      catch (InterruptedException e) {
         e.printStackTrace()
      }

      return new Student(id, "Sajal", "V")
   }

   @Cacheable(value = "student", key = "#id")
   Student getStudentByID(String id, String name) {
      try {
         System.out.println("Going to sleep for 5 Secs.. to simulate backend call.")
         Thread.sleep(1000 * 5)
      }
      catch (InterruptedException e) {
         e.printStackTrace()
      }
      return new Student(id, name, "V")
   }

   @CachePut(value = "student", key = "#student.id")
   Student save(Student student) {
      try {
         System.out.println("Going to sleep for 5 Secs.. to simulate backend call.")
         Thread.sleep(1000 * 5)
      }
      catch (InterruptedException e) {
         e.printStackTrace()
      }
      return student
   }

   @CacheEvict(value = "student", allEntries = true)
   Student clearCache() {
      return null
   }
}