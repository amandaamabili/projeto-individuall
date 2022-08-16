package com.desafiofinal.praticafinal.dto;

import com.desafiofinal.praticafinal.model.Manager;
import com.desafiofinal.praticafinal.model.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDTO {

    private Long managerId;

    @NotEmpty(message = "Manager name cannot be empty.")
    @Size(max = 50, message = "Manager name can't exceed 50 characters.")
    @Pattern(regexp = "^(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:" +
            "\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*(?: (?:(?:" +
            "e|y|de(?:(?: la| las| lo| los))?|do|dos|da|das|del|van|von|bin|le) )?(?:(?:(?:d'|D'|O'|" +
            "Mc|Mac|al\\-))?(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+|(?:" +
            "[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p" +
            "{IsLatin}]]) (?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*))+(?: (?:Jr\\.|II|III|IV))?$")
    private String managerName;


    private WareHouse wareHouse;

    public ManagerDTO(Manager manager){
        this.managerId=manager.getManagerId();
        this.managerName=manager.getManagerName();
    }
}
