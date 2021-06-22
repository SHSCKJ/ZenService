package com.lightshell.zen.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.lightshell.zen.common.SuperService;
import com.lightshell.zen.entity.ConvenientInformation;
import com.lightshell.zen.repository.ConvenientInformationRepository;

@Service
public class ConvenientInformationService implements SuperService<ConvenientInformation> {

    @Autowired
    ConvenientInformationRepository convenientInformationRepository;

    public List<ConvenientInformation> findAll(Integer offset, Integer pageSize) {
        return convenientInformationRepository.findAll(getSpecification(null), PageRequest.of(offset, pageSize))
            .toList();
    }

    public List<ConvenientInformation> findAll(LinkedHashMap<String, Object> filters, Integer offset, Integer pageSize,
        @Nullable LinkedHashMap<String, String> sorts) {
        Pageable pageable;
        if (sorts != null && !sorts.isEmpty()) {
            Sort sort = Sort.by("");
            for (Map.Entry<String, String> entry : sorts.entrySet()) {
                sort = sort.and(Sort.by(Sort.Direction.fromString(entry.getValue()), entry.getValue()));
            }
            pageable = PageRequest.of(offset, pageSize, sort);
        } else {
            pageable = PageRequest.of(offset, pageSize);
        }
        return convenientInformationRepository.findAll(getSpecification(filters), pageable).toList();
    }

    public long getCount() {
        return convenientInformationRepository.count();
    }

    public long getCount(LinkedHashMap<String, Object> map) {
        return convenientInformationRepository.count(getSpecification(map));
    }

    public Specification<ConvenientInformation> getSpecification(LinkedHashMap<String, Object> map) {
        Specification<ConvenientInformation> spec = new Specification<ConvenientInformation>() {
            @Override
            public Predicate toPredicate(Root<ConvenientInformation> root, CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder) {
                Predicate predicate = null;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
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

    @Override
    public ConvenientInformation save(ConvenientInformation convenientInformation) {
        return convenientInformationRepository.save(convenientInformation);
    }

    @Override
    public List<ConvenientInformation> saveAll(List<ConvenientInformation> data) {
        return convenientInformationRepository.saveAll(data);
    }
}
