-- 菜单SQL
INSERT INTO `sys_menu` (`id`,`parent_id`, `name`, `url`, `permission`, `type`, `icon`, `sort`)
    VALUES ('a226fea7f33245bcb3fc50159accfe7d','1', '测试代码生成器', 'gen/gentest.html', 'gentest:list', '1', 'fa fa-file-code-o', '6');

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`id`,`parent_id`, `name`, `url`, `permission`, `type`, `icon`, `sort`)
    SELECT '3733b9170b1e4994bddcf1ce62c4c082','a226fea7f33245bcb3fc50159accfe7d', '查看', null, 'gentest:info', '2', null, '6';
INSERT INTO `sys_menu` (`id`,`parent_id`, `name`, `url`, `permission`, `type`, `icon`, `sort`)
    SELECT '5584eb27178048c6acd7ddef0b173047','a226fea7f33245bcb3fc50159accfe7d', '新增', null, 'gentest:save', '2', null, '6';
INSERT INTO `sys_menu` (`id`,`parent_id`, `name`, `url`, `permission`, `type`, `icon`, `sort`)
    SELECT '9193197e3e0b470d9a18a68e3b0357e6','a226fea7f33245bcb3fc50159accfe7d', '修改', null, 'gentest:update', '2', null, '6';
INSERT INTO `sys_menu` (`id`,`parent_id`, `name`, `url`, `permission`, `type`, `icon`, `sort`)
    SELECT '84999d96d67a423abde2870ac553798b','a226fea7f33245bcb3fc50159accfe7d', '删除', null, 'gentest:delete', '2', null, '6';
