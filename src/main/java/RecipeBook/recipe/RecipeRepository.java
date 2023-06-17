package RecipeBook.recipe;

import RecipeBook.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findRecipeById(Long id);

    List<Recipe> findAllByAppUser(AppUser appUser);
    @Override
    Optional<Recipe> findById(Long aLong);
}
