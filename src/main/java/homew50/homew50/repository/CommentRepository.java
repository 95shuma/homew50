package homew50.homew50.repository;

import homew50.homew50.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository <Comment, String> {
    public Comment findCommentByText(String text);
}
