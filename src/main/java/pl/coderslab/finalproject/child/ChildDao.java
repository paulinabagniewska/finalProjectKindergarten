package pl.coderslab.finalproject.child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.announcement.Announcement;


@Service
public class ChildDao {
  private ChildRepository childRepository;

  @Autowired
    public ChildDao(ChildRepository childRepository){

    this.childRepository = childRepository;
  }
  public  Child saveChild (Child newChild){

    return childRepository.save(newChild);
  }
  public Child child (Child newChild){
    return childRepository.save(newChild);
  }
}
