package com.lightshell.zen.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

/**
 * @author kevindong
 */
public interface SuperService<T> extends Serializable {

    /**
     * 根据条件组成Specification
     * 
     * @param filters
     * @return
     */
    default Specification<T> getSpecification(Map<String, Object> filters) {
        Specification<T> spec = new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = null;
                if (filters != null && !filters.isEmpty()) {
                    for (Map.Entry<String, Object> entry : filters.entrySet()) {
                        Predicate p;
                        Path<Object> path = root.get(entry.getKey());
                        if (entry.getValue() instanceof String) {
                            p = criteriaBuilder.like(path.as(String.class), entry.getValue().toString());
                        } else {
                            p = criteriaBuilder.equal(path, entry.getValue());
                        }

                        predicate = criteriaBuilder.and(p);
                    }
                }
                return predicate;
            }
        };
        return spec;
    }

    void delete(Integer id);

    void deleteByUID(String uid);

    boolean existsById(Integer id);

    boolean existsByUID(String uid);

    List<T> findAll(@Nullable Map<String, String> sorts);

    T findById(Integer id);

    T findByUID(String uid);

    long getCount();

    long getCount(Map<String, Object> filters);

    T save(T t);

    List<T> saveAll(List<T> data);

}
