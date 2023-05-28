package RecipeBook.duration;

import RecipeBook.recipe.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DurationRepository extends JpaRepository<Duration, Long> {

    @Override
    Optional<Duration> findById(Long id);

    Optional<Duration> findByRecipe(Recipe recipe);
}
