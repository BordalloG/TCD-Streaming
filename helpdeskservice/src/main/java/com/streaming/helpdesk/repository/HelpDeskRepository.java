package com.streaming.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.streaming.helpdesk.model.*;

import antlr.collections.List;

@Repository
public interface HelpDeskRepository extends JpaRepository<HelpDesk,String> {

	
}
