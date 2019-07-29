package app.tuanluc.controller

import app.tuanluc.service.StudentService
import app.tuanluc.service.entity.Student
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@CompileStatic
class StudentController {

   @Autowired
   StudentService studentService

   @GetMapping("/search/{id}")
   Student findStudentById(@PathVariable String id) {
      System.out.println("Searching by ID  : " + id)

      return studentService.getStudentByID(id)
   }

   @GetMapping("/search/{id}/{name}")
   Student findStudentByIdName(@PathVariable String id, @PathVariable String name) {
      println("Searching by ID and Name  : $id - $name")
      return studentService.getStudentByID(id, name)
   }

   @GetMapping("/insert/{id}/{name}")
   Student insert(@PathVariable String id, @PathVariable String name) {
      println("insert or update : $id - $name")
      return studentService.save(new Student(id, name, "V"))
   }

   @GetMapping("/clear_cache}")
   Student clearCache() {
      println("clear cache")
      return studentService.clearCache()
   }
}