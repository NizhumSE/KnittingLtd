package com.client.newsBlog.mapper.adminPanel.EntityToDTO;

import com.client.newsBlog.dto.adminPanel.request.PermissionRequestDTO;
import com.client.newsBlog.model.Permissions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class PermissionDTOGetterMapper implements Function<Permissions, PermissionRequestDTO> {
    @Override
    public PermissionRequestDTO apply(Permissions permissions) {
        return new PermissionRequestDTO(
                Long.toString(permissions.getPermissionId()),
                permissions.getURL(),
                Boolean.toString(permissions.isHasSubCategory()),
                permissions.getPermissionName(),
                permissions.getIconPath()
        );
    }
}
