package com.inventnow.projectx.user.dto;

        import io.swagger.annotations.ApiModelProperty;
        import lombok.Data;
        import org.springframework.hateoas.ResourceSupport;

        import java.util.List;
        import java.util.Set;

@Data
public class UserHome extends ResourceSupport {

    @ApiModelProperty(value = "User ID")
    private Long userId;

    @ApiModelProperty(value = "User Name")
    private String userName;

    @ApiModelProperty(value = "First Name")
    private String firstName;

    @ApiModelProperty(value = "Last Name")
    private String lastName;

    @ApiModelProperty(value = "Total Points")
    private Long totalPoints;

    @ApiModelProperty(value = "Roles", example = "ADMIN", allowableValues = "ADMIN,CUSTOMER,MERCHANT_SUPERVISOR,MERCHANT_CASHIER,VISITOR")
    private Set<String> roles;

    private List<Promo> promos;
}
