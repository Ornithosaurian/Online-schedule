package com.example.university.service;

import com.example.university.model.UnGroup;
import com.example.university.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends BaseService<UnGroup, GroupRepository> {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        super(groupRepository);
        this.groupRepository = groupRepository;
    }
}
