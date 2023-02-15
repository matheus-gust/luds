package br.com.luds.Luds.commons.model;

import br.com.luds.Luds.commons.annotation.IgnoreUpdate;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class LudzEntity <T extends LudzEntity>{

    @Getter
    @Setter
    protected LocalDateTime createdAt;

    @Getter
    @Setter
    protected String creationUser;

    @Getter
    @Setter
    protected LocalDateTime lastUpdate;

    @Getter
    @Setter
    protected String lastUpdateUser;

    public void defineMomentoCriacao() {

        this.createdAt = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();

        this.lastUpdateUser = "";

    }

    public void defineMomentoAtualizacao() {
        this.lastUpdate = LocalDateTime.now();
        this.lastUpdateUser = "";
    }


    public void atualiza(T entity) {

        //Define a Classe do Objeto a ser alterado para ser instanciada o novo objeto
        Class<T> entityClass = (Class<T>) entity.getClass();

        try {

            //Recupera os atributos da classe
            List<Field> fields = Arrays.asList(entityClass.getDeclaredFields());

            Optional<IgnoreUpdate> update = Optional.ofNullable(entityClass.getAnnotation(IgnoreUpdate.class));

            List<String> ignoreFields = new ArrayList<>();

            if (update.isPresent()) {
                ignoreFields = Arrays.asList(update.get().fields());
            }

            //Atribui os valores da antiga entidade à nova
            for (Field field : fields) {

                Optional<Annotation> id = Optional.ofNullable(field.getAnnotation(javax.persistence.Id.class));

                if (!id.isPresent() && !ignoreFields.contains(field.getName())) {
                    field.setAccessible(true);
                    field.set(this, field.get(entity));
                }
            }

            this.defineMomentoAtualizacao();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
