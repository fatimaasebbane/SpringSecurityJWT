package ma.trellobackend.trellobackend.utils;

import java.util.List;

/**
 * BaseService
 */
public interface BaseService<Req,Res> {

    String create(Req req);
    String update(Long id, Req req);
    String Delete(Long id);
    List<Res> getAll();
    Res getById(Long id);
    
}