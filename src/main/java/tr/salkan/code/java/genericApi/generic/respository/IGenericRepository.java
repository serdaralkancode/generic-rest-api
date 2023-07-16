package tr.salkan.code.java.genericApi.generic.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository <T, U> extends JpaRepository<T, U>, JpaSpecificationExecutor<T> {
}
