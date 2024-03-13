package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.ImagemEntity;
import br.com.agenda.agenda.repositories.ImagemRepository;
import br.com.agenda.agenda.services.interfaces.IImagemService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ImagemServiceImpl implements IImagemService {

    @Autowired
    private ImagemRepository repository;

    @Override
    public List<ImagemEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ImagemEntity add(ImagemEntity img) {

        img = repository.save(img);

        return img;
    }

    @Override
    public ImagemEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ImagemEntity updateImagem(@RequestBody ImagemEntity img) {

        img = repository.findById(img.getImagemId()).orElse(null);

        img.setImagemId(img.getImagemId());
        img.setImagem(img.getImagem());

        img = repository.save(img);
        return img;
    }
}
