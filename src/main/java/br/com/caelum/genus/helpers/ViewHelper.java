package br.com.caelum.genus.helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import br.com.caelum.genus.models.Status;

@Component
@RequestScope
public class ViewHelper {

    public Status[] statusList() {
	return Status.values();
    }

}
