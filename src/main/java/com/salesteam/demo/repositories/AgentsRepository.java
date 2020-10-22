package com.salesteam.demo.repositories;

import com.salesteam.demo.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent,Long> {

}
