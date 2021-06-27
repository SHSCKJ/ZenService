package com.lightshell.zen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.lightshell.zen.common.SuperService;
import com.lightshell.zen.entity.ConvenientInformation;
import com.lightshell.zen.repository.ConvenientInformationRepository;

/**
 * @author kevindong
 */
@Service
public class ConvenientInformationServiceImpl implements SuperService<ConvenientInformation> {

    @Autowired
    ConvenientInformationRepository convenientInformationRepository;

    @Override
    public void delete(Integer id) {
        convenientInformationRepository.deleteById(id);
    }

    @Override
    public void deleteByUID(String uid) {
        ConvenientInformation entity = convenientInformationRepository.findByUIDEquals(uid);
        if (entity != null) {
            convenientInformationRepository.delete(entity);
        } else {
            throw new NullPointerException(uid);
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return convenientInformationRepository.existsById(id);
    }

    @Override
    public boolean existsByUID(String uid) {
        ConvenientInformation entity = convenientInformationRepository.findByUIDEquals(uid);
        return entity != null;
    }

    @Override
    public List<ConvenientInformation> findAll(@Nullable Map<String, String> sorts) {
        if (sorts != null && !sorts.isEmpty()) {
            Sort sort = null;
            for (Map.Entry<String, String> entry : sorts.entrySet()) {
                if (sort == null) {
                    sort = Sort.by(Sort.Direction.fromString(entry.getValue()), entry.getKey());
                } else {
                    sort = sort.and(Sort.by(Sort.Direction.fromString(entry.getValue()), entry.getKey()));
                }
            }
            return convenientInformationRepository.findAll(sort);
        }
        return convenientInformationRepository.findAll();
    }

    @Override
    public ConvenientInformation findById(Integer id) {
        try {
            return convenientInformationRepository.findById(id).get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public ConvenientInformation findByUID(String uid) {
        return convenientInformationRepository.findByUIDEquals(uid);
    }

    @Override
    public long getCount() {
        return convenientInformationRepository.count();
    }

    @Override
    public long getCount(Map<String, Object> filters) {
        return convenientInformationRepository.count(getSpecification(filters));
    }

    @Override
    public ConvenientInformation save(ConvenientInformation convenientInformation) {
        return convenientInformationRepository.save(convenientInformation);
    }

    @Override
    public List<ConvenientInformation> saveAll(List<ConvenientInformation> data) {
        return convenientInformationRepository.saveAll(data);
    }

    public List<ConvenientInformation> findAll(Integer offset, Integer pageSize) {
        return convenientInformationRepository.findAll(getSpecification(null), PageRequest.of(offset, pageSize))
            .toList();
    }

    public List<ConvenientInformation> findAll(Map<String, Object> filters, Integer offset, Integer pageSize,
        @Nullable Map<String, String> sorts) {
        Pageable pageable;
        if (sorts != null && !sorts.isEmpty()) {
            Sort sort = null;
            for (Map.Entry<String, String> entry : sorts.entrySet()) {
                if (sort == null) {
                    sort = Sort.by(Sort.Direction.fromString(entry.getValue()), entry.getKey());
                } else {
                    sort = sort.and(Sort.by(Sort.Direction.fromString(entry.getValue()), entry.getKey()));
                }
            }
            pageable = PageRequest.of(offset, pageSize, sort);
        } else {
            pageable = PageRequest.of(offset, pageSize);
        }
        return convenientInformationRepository.findAll(getSpecification(filters), pageable).toList();
    }

}
