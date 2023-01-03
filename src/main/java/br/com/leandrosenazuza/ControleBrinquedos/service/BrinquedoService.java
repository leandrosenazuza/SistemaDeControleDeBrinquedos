package br.com.leandrosenazuza.ControleBrinquedos.service;

import br.com.leandrosenazuza.ControleBrinquedos.dto.BrinquedoDTO;
import br.com.leandrosenazuza.ControleBrinquedos.model.Brinquedo;
import br.com.leandrosenazuza.ControleBrinquedos.repository.BrinquedoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {
    //A classe service irá chamar o repositório
    final BrinquedoRepository brinquedoRepository;

    public BrinquedoService(BrinquedoRepository brinquedoRepository){
        this.brinquedoRepository = brinquedoRepository;
    }

    @Transactional
    public Brinquedo persistirBrinquedoService(Brinquedo brinquedoAux){
        return brinquedoRepository.save(brinquedoAux);
    }

    public Optional<Brinquedo> buscarBrinquedoService(int id){
        Optional<Brinquedo> brinquedoOptional = brinquedoRepository.findById(id);
        return brinquedoOptional;
    }

    public List<Brinquedo> buscarTodosBrinquedosService(){
        return brinquedoRepository.findAll();
    }

    public boolean alterarBrinquedoService(int id, BrinquedoDTO brinquedoDTOAux){
        Brinquedo brinquedo = new Brinquedo();
        brinquedo.setId_brinquedo(id);
        brinquedo.setNome_brinquedo(brinquedoDTOAux.getNome_brinquedo());
       try{
           brinquedoRepository.save(brinquedo);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    @Transactional
    public boolean deletarRegistroBrinquedo(int id) {
        try{
            brinquedoRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
