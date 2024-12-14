package com.pascaldev.course_service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pascaldev.course_service.dto.CourseDto;
import com.pascaldev.course_service.dto.SubjectDto;
import com.pascaldev.course_service.model.Course;
import com.pascaldev.course_service.model.Subject;
import com.pascaldev.course_service.repository.CourseRepository;
import com.pascaldev.course_service.repository.SubjectRepository;
import com.pascaldev.course_service.service.CourseService;
import com.pascaldev.pascaldev_utild_service.model.PascalDevException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourserServiceImpl implements CourseService<CourseDto> {
	
	private final CourseRepository courseRepository;
	private final SubjectRepository subjectRepository;

	@Override
	public CourseDto getById(Long id) {
		log.trace("try to get course by id  : {}", id);

		try {
			Optional<Course> course = courseRepository.findById(id);
			if (!course.isPresent()) {
				log.trace("this course does not exist");
				return null;
			}
			Course newCourse = course.get();
			return CourseDto.fromCourse(newCourse);
		} catch (PascalDevException e) {
//			String message = messageSource.getMessage("not found user",new Object[] {user}, locale);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "not found course");
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<CourseDto> getAll() {
		log.trace("try  to find all courses");
		Page<Course> items = courseRepository.findAll(PageRequest.of(0, 5));
		List<Course> courses = items.getContent();
		if (courses.isEmpty()) {
			log.trace("this list is empty");
			return null;
		}
		List<CourseDto> courseDtos = new ArrayList<>();
		for (Course course : courses) {
			courseDtos.add(CourseDto.fromCourse(course));
		}
		return courseDtos;
	}

	@Override
	public CourseDto save(CourseDto courseDto) {
		log.trace("try to save course : {}", courseDto);

		try {
			if (courseDto == null) {
				throw new PascalDevException("unable.save.null.course");
			}
			if (!StringUtils.hasText(courseDto.getCourseName())) {
				throw new PascalDevException("unable.save.course.with.empty.name");
			}
			Optional<Course> course = courseRepository.findById(CourseDto.fromUserDto(courseDto).getId());
			if (course.isPresent()) {
				log.trace("this user already exist");
				return null;
			}
			Course newCourse = courseRepository.save(CourseDto.fromUserDto(courseDto));
			return CourseDto.fromCourse(newCourse);

		} catch (PascalDevException e) {
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error while save course : {}", courseDto, e);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "unable.to.save.course");
		}
	}

	@Override
	public CourseDto update(Long id, CourseDto courseDto) {
		Course course = CourseDto.fromUserDto(getById(id));
		if (course == null) {
			throw new PascalDevException("unable.to.update.null.course");

		}
		course.setCourseName(courseDto.getCourseName());
		//course.setSubjects(courseDto.getSubjects());

		CourseDto savedCourseDto = save(CourseDto.fromCourse(course));

		return savedCourseDto;
	}

	@Override
	public void deleteById(Long id) {
		log.trace("try to delete course by id: {}", id);
		try {
			if (id == null) {
				throw new PascalDevException("unable.to.delete.null.course");
			}
			courseRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void deleteAll() {
		log.trace("try to delete allCourse : {}");

		courseRepository.deleteAll();

	}
	
	public List<SubjectDto> getAllSubjects() {
		log.trace("try  to find all subjects");
		Page<Subject> items = subjectRepository.findAll(PageRequest.of(0, 5));
		List<Subject> subjects = items.getContent();
		if (subjects.isEmpty()) {
			log.trace("this list is empty");
			return null;
		}
		List<SubjectDto> subjectDtos = new ArrayList<>();
		for (Subject subject : subjects) {
			subjectDtos.add(SubjectDto.fromSubject(subject));
		}
		return subjectDtos;
		
		
        
    }

    public SubjectDto getSubjectById(Long id) {
    	log.trace("try to get course by id  : {}", id);

		try {
			Optional<Subject> subject = subjectRepository.findById(id);
			if (!subject.isPresent()) {
				log.trace("this subject does not exist");
				return null;
			}
			Subject newSubject = subject.get();
			return SubjectDto.fromSubject(newSubject);
		} catch (PascalDevException e) {
//			String message = messageSource.getMessage("not found user",new Object[] {user}, locale);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "not found course");
		} catch (Exception e) {
			throw e;
		}
    	
        
        
    }

    public SubjectDto createSubject(SubjectDto subjectDto) {
    	log.trace("try to save subject : {}", subjectDto);

		try {
			if (subjectDto == null) {
				throw new PascalDevException("unable.save.null.subject");
			}
			if (!StringUtils.hasText(subjectDto.getSubjectName())) {
				throw new PascalDevException("unable.save.subject.with.empty.name");
			}
			Optional<Subject> subject = subjectRepository.findById(SubjectDto.fromSubjectDto(subjectDto).getId());
			
			if (subject.isPresent()) {
				log.trace("this subject already exist");
				return null;
			}
			Course course = courseRepository.findByCourseName(subjectDto.getCourseDto().getCourseName());
			subjectDto.setCourseDto(CourseDto.fromCourse(course));
			Subject newSubject = subjectRepository.save(SubjectDto.fromSubjectDto(subjectDto));
			return SubjectDto.fromSubject(newSubject);

		} catch (PascalDevException e) {
			throw e;
		} catch (Exception e) {
			log.error("Unexpected error while save subject : {}", subjectDto, e);
			throw new PascalDevException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "unable.to.save.subject");
		}
    	
    }

    public SubjectDto updateSubject(Long id, SubjectDto subjectDto) {
    	Subject subject = SubjectDto.fromSubjectDto(getSubjectById(id));
		if (subject == null) {
			throw new PascalDevException("unable.to.update.null.subject");

		}
		subject.setSubjectName(subjectDto.getSubjectName());
		subject.setSubjectDesription(subjectDto.getSubjectDesription());
		subject.setCourse(CourseDto.fromUserDto(subjectDto.getCourseDto()));

		SubjectDto savedSubjectDto = createSubject(SubjectDto.fromSubject(subject));

		return savedSubjectDto;
    	
       
    }

    public void deleteSubject(Long id) {
    	log.trace("try to delete subject by id: {}", id);
		try {
			if (id == null) {
				throw new PascalDevException("unable.to.delete.null.course");
			}
			subjectRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

}
